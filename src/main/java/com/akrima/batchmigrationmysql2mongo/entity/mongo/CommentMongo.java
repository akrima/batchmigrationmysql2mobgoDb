package com.akrima.batchmigrationmysql2mongo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("comments")
public record CommentMongo(
        @Id
        String commentId,

        String userId,
        String productId,
        String commentText,
        Date createdAt,
        Date updatedAt
) {
}
