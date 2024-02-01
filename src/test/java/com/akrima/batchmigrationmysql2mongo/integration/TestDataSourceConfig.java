package com.akrima.batchmigrationmysql2mongo.integration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@TestConfiguration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})
@ComponentScan("com.akrima.batchmigrationmysql2mongo")
public class TestDataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(BatchIntegrationTest.mySQLContainer.getJdbcUrl());
        dataSource.setUsername(BatchIntegrationTest.mySQLContainer.getUsername());
        dataSource.setPassword(BatchIntegrationTest.mySQLContainer.getPassword());
        dataSource.setDriverClassName(BatchIntegrationTest.mySQLContainer.getDriverClassName());

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        initializeDatabase(jdbcTemplate);
        
        return dataSource;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "testdb");
    }

    private MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://" +
                BatchIntegrationTest.mongoContainer.getContainerIpAddress() + ":" +
                BatchIntegrationTest.mongoContainer.getMappedPort(27017));

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    private void initializeDatabase(JdbcTemplate jdbcTemplate) {
        String insertUserData = """
                INSERT INTO users (username, email, password, first_name, last_name, created_at, updated_at) VALUES 
                ('user1', 'user1@example.com', 'password1', 'John', 'Doe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user2', 'user2@example.com', 'password2', 'Jane', 'Smith', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user3', 'user3@example.com', 'password3', 'Bob', 'Johnson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user4', 'user4@example.com', 'password4', 'Alice', 'Williams', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user5', 'user5@example.com', 'password5', 'Charlie', 'Brown', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user6', 'user6@example.com', 'password6', 'Emma', 'Davis', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user7', 'user7@example.com', 'password7', 'Frank', 'Miller', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user8', 'user8@example.com', 'password8', 'Grace', 'Jones', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user9', 'user9@example.com', 'password9', 'Henry', 'Smith', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), 
                ('user10', 'user10@example.com', 'password10', 'Ivy', 'Johnson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
                """;
        String insertProductData = """
                INSERT INTO products (name, description, price, stock_quantity, created_at, updated_at) VALUES 
                ('Product A', 'Description for Product A', 29.99, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product B', 'Description for Product B', 39.99, 150, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product C', 'Description for Product C', 49.99, 200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product D', 'Description for Product D', 19.99, 80, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product E', 'Description for Product E', 59.99, 120, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product F', 'Description for Product F', 69.99, 90, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product G', 'Description for Product G', 24.99, 110, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product H', 'Description for Product H', 34.99, 180, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product I', 'Description for Product I', 44.99, 70, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                ('Product J', 'Description for Product J', 54.99, 130, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
                """;

        String insertOrderData = """
                INSERT INTO orders (user_id, order_date, total_amount, status, created_at, updated_at) VALUES
                (1, '2024-01-01 12:00:00', 79.98, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (2, '2024-01-02 13:30:00', 129.75, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (3, '2024-01-03 14:45:00', 49.99, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (4, '2024-01-04 10:15:00', 89.50, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (5, '2024-01-05 16:20:00', 179.99, 'Pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (6, '2024-01-06 09:00:00', 64.75, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (7, '2024-01-07 11:45:00', 94.20, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (8, '2024-01-08 15:10:00', 124.50, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (9, '2024-01-09 14:30:00', 54.99, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (10, '2024-01-10 17:05:00', 134.75, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
                """;

        String insertOrderItemData = """
                INSERT INTO order_items (order_id, product_id, quantity, subtotal, created_at, updated_at) VALUES
                (1, 1, 2, 59.98, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (2, 2, 1, 49.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (3, 3, 3, 179.97, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (4, 4, 2, 189.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (5, 5, 1, 134.75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (6, 6, 2, 188.40, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (7, 7, 3, 282.60, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (8, 8, 1, 124.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (9, 9, 4, 219.96, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (10, 10, 2, 269.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
                """;
        String insertCommentData = """
                INSERT INTO comments (user_id, product_id, comment_text, created_at, updated_at) VALUES
                (1, 1, 'Great product!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (2, 2, 'Awesome quality!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (3, 3, 'Very satisfied with my purchase.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (4, 4, 'Excellent service and fast delivery!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (5, 5, 'Love it! Will buy again.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (6, 6, 'Impressed with the design.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (7, 7, 'Highly recommended!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (8, 8, 'Exactly what I was looking for.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (9, 9, 'Great value for money.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (10, 10, 'Fast shipping and well-packaged.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
                """;

        String insertAddressData = """
                INSERT INTO addresses (user_id, street, city, state, zip_code, country, created_at, updated_at) VALUES
                (1, '123 Main St', 'Cityville', 'Stateville', '12345', 'Countryland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (2, '456 Oak St', 'Townsville', 'Provinceville', '56789', 'Countryville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (3, '789 Pine St', 'Villagetown', 'Territoryville', '98765', 'Landville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (4, '321 Maple St', 'Hamletville', 'Regionville', '54321', 'Worldland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (5, '654 Birch St', 'Metropolis', 'Districtville', '13579', 'Globaland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (6, '987 Cedar St', 'Citytown', 'Countyville', '24680', 'Planetland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (7, '135 Elm St', 'Suburbville', 'Countryville', '86420', 'Universeville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (8, '246 Pineapple St', 'Townville', 'Provinceville', '11111', 'Continentland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (9, '543 Banana St', 'Villageland', 'Territoryville', '22222', 'Landland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (10, '876 Orange St', 'Cityland', 'Stateville', '33333', 'Countryland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
                """;

        jdbcTemplate.execute(insertUserData);
        jdbcTemplate.execute(insertProductData);
        jdbcTemplate.execute(insertAddressData);
        jdbcTemplate.execute(insertCommentData);
        jdbcTemplate.execute(insertOrderData);
        jdbcTemplate.execute(insertOrderItemData);

    }
}
