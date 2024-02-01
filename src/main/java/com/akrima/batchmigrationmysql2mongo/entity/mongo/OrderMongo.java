package com.akrima.batchmigrationmysql2mongo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("orders")
public record OrderMongo(
        @Id
        String orderId,

        Long userId,

        Date orderDate,
        Double totalAmount,
        String status,
        Date createdAt,
        Date updatedAt
) {
}
