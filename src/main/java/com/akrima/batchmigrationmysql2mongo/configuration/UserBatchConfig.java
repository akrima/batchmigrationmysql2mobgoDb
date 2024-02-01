package com.akrima.batchmigrationmysql2mongo.configuration;


import com.akrima.batchmigrationmysql2mongo.entity.jpa.UserJpa;
import com.akrima.batchmigrationmysql2mongo.entity.mongo.UserMongo;
import com.akrima.batchmigrationmysql2mongo.processor.UserItemProcessor;
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
public class UserBatchConfig extends BatchConfig{
    public UserBatchConfig(MongoTemplate mongoTemplate, EntityManagerFactory mysqlEntityManagerFactory) {
        super(mongoTemplate, mysqlEntityManagerFactory);
    }

    @Bean
    public ItemReader<UserJpa> userItemReader() {
        return new JpaPagingItemReaderBuilder<UserJpa>()
                .name("userItemReader")
                .entityManagerFactory(mysqlEntityManagerFactory)
                .queryString("SELECT u from UserJpa u")
                .build();
    }

    @Bean
    public ItemWriter<UserMongo> userItemWriter() {
        mongoTemplate.createCollection(UserMongo.class.getSimpleName());
        return items -> {
            for (UserMongo item : items) {
                mongoTemplate.save(item);
            }
        };
    }

    @Bean(name = "userJob")
    public Job userJob(JobRepository jobRepository, JpaTransactionManager jpaTransactionManager,
                          ItemReader<UserJpa> userItemReader, ItemWriter<UserMongo> userItemWriter) {
        return new JobBuilder("userJob", jobRepository)
                .start(new StepBuilder("stepUser", jobRepository)
                        .<UserJpa, UserMongo>chunk(10, jpaTransactionManager)
                        .reader(userItemReader)
                        .processor(new UserItemProcessor())
                        .writer(userItemWriter)
                        .build())
                .build();
    }
}
