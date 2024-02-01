package com.akrima.batchmigrationmysql2mongo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("order_items")
public record OrderItemMongo(
        @Id
        String orderItemId,

        String orderId,
        String productId,
        Integer quantity,
        Double subtotal,
        Date createdAt,
        Date updatedAt
) {
}
