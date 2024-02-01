package com.akrima.batchmigrationmysql2mongo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("products")
public record ProductMongo(
        @Id
        String productId,

        String name,
        String description,
        Double price,
        Integer stockQuantity,
        Date createdAt,
        Date updatedAt
) {
}
