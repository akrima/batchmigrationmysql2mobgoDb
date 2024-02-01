package com.akrima.batchmigrationmysql2mongo.processor;


import com.akrima.batchmigrationmysql2mongo.entity.mongo.OrderItemMongo;
import com.akrima.batchmigrationmysql2mongo.entity.jpa.OrderItemJpa;
import org.springframework.batch.item.ItemProcessor;

public class OrderItemItemProcessor implements ItemProcessor<OrderItemJpa, OrderItemMongo> {

    @Override
    public OrderItemMongo process(OrderItemJpa orderItemJpa) {
        // We can apply here any kind of transformation before insertion to cassandra DB
        return new OrderItemMongo(
                orderItemJpa.getOrderItemId().toString(),
                orderItemJpa.getOrder().getOrderId().toString(),
                orderItemJpa.getProduct().getProductId().toString(),
                orderItemJpa.getQuantity(),
                orderItemJpa.getSubtotal(),
                orderItemJpa.getCreatedAt(),
                orderItemJpa.getUpdatedAt()
        );
    }
}
