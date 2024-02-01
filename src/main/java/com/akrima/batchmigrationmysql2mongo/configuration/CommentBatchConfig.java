package com.akrima.batchmigrationmysql2mongo.configuration;

import com.akrima.batchmigrationmysql2mongo.entity.jpa.CommentJpa;
import com.akrima.batchmigrationmysql2mongo.entity.mongo.CommentMongo;
import com.akrima.batchmigrationmysql2mongo.processor.CommentItemProcessor;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class CommentBatchConfig extends BatchConfig{
    public CommentBatchConfig(MongoTemplate mongoTemplate, EntityManagerFactory mysqlEntityManagerFactory) {
        super(mongoTemplate, mysqlEntityManagerFactory);
    }

    @Bean
    public ItemReader<CommentJpa> commentItemReader() {
        return new JpaPagingItemReaderBuilder<CommentJpa>()
                .name("commentItemReader")
                .entityManagerFactory(mysqlEntityManagerFactory)
                .queryString("SELECT c from CommentJpa c")
                .build();
    }

    @Bean
    public ItemWriter<CommentMongo> commentItemWriter() {
        mongoTemplate.createCollection(CommentMongo.class.getSimpleName());
        return items -> {
            for (CommentMongo item : items) {
                mongoTemplate.save(item);
            }
        };
    }

    @Bean(name = "commentJob")
    public Job commentJob(JobRepository jobRepository, JpaTransactionManager jpaTransactionManager,
                          ItemReader<CommentJpa> commentItemReader, ItemWriter<CommentMongo> commentItemWriter) {
        return new JobBuilder("commentJob", jobRepository)
                .start(new StepBuilder("stepComment", jobRepository)
                        .<CommentJpa, CommentMongo>chunk(10, jpaTransactionManager)
                        .reader(commentItemReader)
                        .processor(new CommentItemProcessor())
                        .writer(commentItemWriter)
                        .build())
                .build();
    }
}
