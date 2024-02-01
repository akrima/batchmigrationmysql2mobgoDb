package com.akrima.batchmigrationmysql2mongo.configuration;



import com.akrima.batchmigrationmysql2mongo.entity.jpa.OrderJpa;
import com.akrima.batchmigrationmysql2mongo.entity.mongo.OrderMongo;
import com.akrima.batchmigrationmysql2mongo.processor.OrderItemProcessor;
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
public class OrderBatchConfig extends BatchConfig{
    public OrderBatchConfig(MongoTemplate mongoTemplate, EntityManagerFactory mysqlEntityManagerFactory) {
        super(mongoTemplate, mysqlEntityManagerFactory);
    }

    @Bean
    public ItemReader<OrderJpa> orderItemReader() {
        return new JpaPagingItemReaderBuilder<OrderJpa>()
                .name("orderItemReader")
                .entityManagerFactory(mysqlEntityManagerFactory)
                .queryString("SELECT o from OrderJpa o")
                .build();
    }

    @Bean
    public ItemWriter<OrderMongo> orderItemWriter() {
        mongoTemplate.createCollection(OrderMongo.class.getSimpleName());
        return items -> {
            for (OrderMongo item : items) {
                mongoTemplate.save(item);
            }
        };
    }

    @Bean(name = "orderJob")
    public Job orderJob(JobRepository jobRepository, JpaTransactionManager jpaTransactionManager,
                          ItemReader<OrderJpa> orderItemReader, ItemWriter<OrderMongo> orderItemWriter) {
        return new JobBuilder("orderJob", jobRepository)
                .start(new StepBuilder("stepOrder", jobRepository)
                        .<OrderJpa, OrderMongo>chunk(10, jpaTransactionManager)
                        .reader(orderItemReader)
                        .processor(new OrderItemProcessor())
                        .writer(orderItemWriter)
                        .build())
                .build();
    }
}
