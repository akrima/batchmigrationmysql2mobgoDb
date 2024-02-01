package com.akrima.batchmigrationmysql2mongo.configuration;

import com.akrima.batchmigrationmysql2mongo.entity.jpa.OrderItemJpa;
import com.akrima.batchmigrationmysql2mongo.entity.mongo.OrderItemMongo;
import com.akrima.batchmigrationmysql2mongo.processor.OrderItemItemProcessor;
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
public class OrderItemBatchConfig extends BatchConfig{
    public OrderItemBatchConfig(MongoTemplate mongoTemplate, EntityManagerFactory mysqlEntityManagerFactory) {
        super(mongoTemplate, mysqlEntityManagerFactory);
    }

    @Bean
    public ItemReader<OrderItemJpa> orderItemItemReader() {
        return new JpaPagingItemReaderBuilder<OrderItemJpa>()
                .name("orderItemReader")
                .entityManagerFactory(mysqlEntityManagerFactory)
                .queryString("SELECT ot from OrderItemJpa ot")
                .build();
    }

    @Bean
    public ItemWriter<OrderItemMongo> orderItemItemWriter() {
        mongoTemplate.createCollection(OrderItemMongo.class.getSimpleName());
        return items -> {
            for (OrderItemMongo item : items) {
                mongoTemplate.save(item);
            }
        };
    }

    @Bean(name = "orderItemJob")
    public Job orderItemJob(JobRepository jobRepository, JpaTransactionManager jpaTransactionManager,
                          ItemReader<OrderItemJpa> orderItemItemReader, ItemWriter<OrderItemMongo> orderItemItemWriter) {
        return new JobBuilder("orderItemJob", jobRepository)
                .start(new StepBuilder("stepItemItem", jobRepository)
                        .<OrderItemJpa, OrderItemMongo>chunk(10, jpaTransactionManager)
                        .reader(orderItemItemReader)
                        .processor(new OrderItemItemProcessor())
                        .writer(orderItemItemWriter)
                        .build())
                .build();
    }
}
