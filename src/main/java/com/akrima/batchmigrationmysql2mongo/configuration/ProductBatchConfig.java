package com.akrima.batchmigrationmysql2mongo.configuration;

import com.akrima.batchmigrationmysql2mongo.entity.jpa.ProductJpa;
import com.akrima.batchmigrationmysql2mongo.entity.mongo.ProductMongo;
import com.akrima.batchmigrationmysql2mongo.processor.ProductItemProcessor;
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
public class ProductBatchConfig extends BatchConfig{
    public ProductBatchConfig(MongoTemplate mongoTemplate, EntityManagerFactory mysqlEntityManagerFactory ) {
        super(mongoTemplate, mysqlEntityManagerFactory);
    }

    @Bean
    public ItemReader<ProductJpa> productItemReader() {
        return new JpaPagingItemReaderBuilder<ProductJpa>()
                .name("productItemReader")
                .entityManagerFactory(mysqlEntityManagerFactory)
                .queryString("SELECT p from ProductJpa p")
                .build();
    }

    @Bean
    public ItemWriter<ProductMongo> productItemWriter() {
        mongoTemplate.createCollection(ProductMongo.class.getSimpleName());
        return items -> {
            for (ProductMongo item : items) {
                mongoTemplate.save(item);
            }
        };
    }
    @Bean(name = "productJob")
    public Job productJob(JobRepository jobRepository, JpaTransactionManager jpaTransactionManager,
                          ItemReader<ProductJpa> productItemReader, ItemWriter<ProductMongo> productItemWriter) {
        return new JobBuilder("productJob", jobRepository)
                .start(new StepBuilder("stepProduct", jobRepository)
                        .<ProductJpa, ProductMongo>chunk(10, jpaTransactionManager)
                        .reader(productItemReader)
                        .processor(new ProductItemProcessor())
                        .writer(productItemWriter)
                        .build())
                .build();
    }
}
