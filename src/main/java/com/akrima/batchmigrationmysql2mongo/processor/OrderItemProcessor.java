package com.akrima.batchmigrationmysql2mongo.processor;

import com.akrima.batchmigrationmysql2mongo.entity.mongo.OrderMongo;
import com.akrima.batchmigrationmysql2mongo.entity.jpa.OrderJpa;
import org.springframework.batch.item.ItemProcessor;

public class OrderItemProcessor implements ItemProcessor<OrderJpa, OrderMongo> {

    @Override
    public OrderMongo process(OrderJpa orderJpa) {
        // We can apply here any kind of transformation before insertion to cassandra DB
        return new OrderMongo(
                orderJpa.getOrderId().toString(),
                orderJpa.getUser().getUserId(),
                orderJpa.getOrderDate(),
                orderJpa.getTotalAmount(),
                orderJpa.getStatus(),
                orderJpa.getCreatedAt(),
                orderJpa.getUpdatedAt()
        );
    }
}
