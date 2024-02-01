package com.akrima.batchmigrationmysql2mongo.processor;


import com.akrima.batchmigrationmysql2mongo.entity.mongo.CommentMongo;
import com.akrima.batchmigrationmysql2mongo.entity.jpa.CommentJpa;
import org.springframework.batch.item.ItemProcessor;

public class CommentItemProcessor implements ItemProcessor<CommentJpa, CommentMongo> {

    @Override
    public CommentMongo process(CommentJpa commentJpa) {
        // We can apply here any kind of transformation before insertion to cassandra DB
        return new CommentMongo(
                commentJpa.getCommentId().toString(),
                commentJpa.getUser().getUserId().toString(),
                commentJpa.getProduct().getProductId().toString(),
                commentJpa.getCommentText(),
                commentJpa.getCreatedAt(),
                commentJpa.getUpdatedAt()
        );
    }
}
