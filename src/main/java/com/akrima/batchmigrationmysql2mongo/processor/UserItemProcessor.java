package com.akrima.batchmigrationmysql2mongo.processor;

import com.akrima.batchmigrationmysql2mongo.entity.jpa.UserJpa;
import com.akrima.batchmigrationmysql2mongo.entity.mongo.UserMongo;
import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<UserJpa, UserMongo> {

    @Override
    public UserMongo process(UserJpa userJpa) {
        // We can apply here any kind of transformation before insertion to cassandra DB
        UserMongo userMongo = new UserMongo(
                userJpa.getUserId().toString(),
                userJpa.getUsername(),
                userJpa.getEmail(),
                userJpa.getPassword(),
                userJpa.getFirstName(),
                userJpa.getLastName(),
                userJpa.getCreatedAt(),
                userJpa.getUpdatedAt()
        );
        return userMongo;
    }
}
