package com.akrima.batchmigrationmysql2mongo.configuration;

import com.akrima.batchmigrationmysql2mongo.entity.jpa.AddressJpa;
import com.akrima.batchmigrationmysql2mongo.entity.mongo.AddressMongo;
import com.akrima.batchmigrationmysql2mongo.processor.AddressItemProcessor;
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
public class AddressBatchConfig extends BatchConfig {
    public AddressBatchConfig(MongoTemplate mongoTemplate, EntityManagerFactory mysqlEntityManagerFactory ) {
        super(mongoTemplate, mysqlEntityManagerFactory);
    }

    @Bean
    public ItemReader<AddressJpa> adressItemReader() {
        return new JpaPagingItemReaderBuilder<AddressJpa>()
                .name("addressItemReader")
                .entityManagerFactory(mysqlEntityManagerFactory)
                .queryString("SELECT ad from AddressJpa ad")
                .build();
    }

    @Bean
    public ItemWriter<AddressMongo> addressItemWriter() {
        mongoTemplate.createCollection(AddressMongo.class.getSimpleName());
        return items -> {
            for (AddressMongo item : items) {
                mongoTemplate.save(item);
            }
        };
    }

    @Bean(name = "addressJob")
    public Job addressJob(JobRepository jobRepository, JpaTransactionManager jpaTransactionManager,
                       ItemReader<AddressJpa> adressItemReader, ItemWriter<AddressMongo> addressItemWriter) {
        return new JobBuilder("addressJob", jobRepository)
                .start(new StepBuilder("stepAddress", jobRepository)
                        .<AddressJpa, AddressMongo>chunk(10, jpaTransactionManager)
                        .reader(adressItemReader)
                        .processor(new AddressItemProcessor())
                        .writer(addressItemWriter)
                        .build())
                .build();
    }
}
