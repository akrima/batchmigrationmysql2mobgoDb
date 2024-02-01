package com.akrima.batchmigrationmysql2mongo.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

public class BatchConfig {

    protected final MongoTemplate mongoTemplate;

    protected final EntityManagerFactory mysqlEntityManagerFactory;

    public BatchConfig(MongoTemplate mongoTemplate, EntityManagerFactory mysqlEntityManagerFactory) {
        this.mongoTemplate = mongoTemplate;
        this.mysqlEntityManagerFactory = mysqlEntityManagerFactory;
    }

}
