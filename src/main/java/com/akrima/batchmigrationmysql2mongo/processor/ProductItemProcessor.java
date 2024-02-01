package com.akrima.batchmigrationmysql2mongo.processor;

import com.akrima.batchmigrationmysql2mongo.entity.mongo.ProductMongo;
import com.akrima.batchmigrationmysql2mongo.entity.jpa.ProductJpa;
import org.springframework.batch.item.ItemProcessor;

public class ProductItemProcessor implements ItemProcessor<ProductJpa, ProductMongo> {

    @Override
    public ProductMongo process(ProductJpa productJpa) {
        // We can apply here any kind of transformation before insertion to cassandra DB
        System.out.println("");
        return new ProductMongo(
                productJpa.getProductId().toString(),
                productJpa.getName(),
                productJpa.getDescription(),
                productJpa.getPrice(),
                productJpa.getStockQuantity(),
                productJpa.getCreatedAt(),
                productJpa.getUpdatedAt()
        );
    }
}
