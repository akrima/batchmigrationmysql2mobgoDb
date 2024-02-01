package com.akrima.batchmigrationmysql2mongo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("addresses")
public record AddressMongo(
        @Id
        String addressId,

        String userId,
        String street,
        String city,
        String state,
        String zipCode,
        String country,
        Date createdAt,
        Date updatedAt
) {
}
