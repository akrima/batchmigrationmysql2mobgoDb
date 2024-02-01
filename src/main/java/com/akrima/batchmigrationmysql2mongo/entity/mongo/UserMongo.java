package com.akrima.batchmigrationmysql2mongo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("users")
public record UserMongo(
        @Id
        String userId,

        String username,
        String email,
        String password,
        String firstName,
        String lastName,
        Date createdAt,
        Date updatedAt
) {
}
