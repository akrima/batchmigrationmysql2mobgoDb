package com.akrima.batchmigrationmysql2mongo.integration;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;


@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import({TestDataSourceConfig.class})
public class BatchIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    private final String BASE_URL = "/v1/api/batch";

    @Autowired
    private ApplicationContext context;

    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer<>(DockerImageName.parse("mysql:8.0-debian"))
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass")
            .withInitScript("db/schema.sql");

    @Container
    static MongoDBContainer mongoContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"))
            .withExposedPorts(27017)
            .waitingFor(Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(60)));

    @Test
    @DisplayName("Executing batch to retrieve data from MySQL 'Product' table and insert into MongoDB 'Product' document")
    public void testBatchJobProduct() throws Exception {
        webTestClient.get()
                .uri(BASE_URL + "/migrate/products")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("COMPLETED");

    }
    @Test
    @DisplayName("Executing batch to retrieve data from MySQL 'User' table and insert into MongoDB 'User' document")
    public void testBatchJobUsers() throws Exception {

        webTestClient.get()
                .uri(BASE_URL + "/migrate/users")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("COMPLETED");

    }

    @Test
    @DisplayName("Executing batch to retrieve data from MySQL 'Address' table and insert into MongoDB 'Address' document")
    public void testBatchJobAddress() throws Exception {

        webTestClient.get()
                .uri(BASE_URL + "/migrate/address")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("COMPLETED");

    }

    @Test
    @DisplayName("Executing batch to retrieve data from MySQL 'Comment' table and insert into MongoDB 'Comment' document")
    public void testBatchJobComments() throws Exception {
        webTestClient.get()
                .uri(BASE_URL + "/migrate/comments")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("COMPLETED");
    }

    @Test
    @DisplayName("Executing batch to retrieve data from MySQL 'Order' table and insert into MongoDB 'Order' document")
    public void testBatchJobOrders() throws Exception {
        webTestClient.get()
                .uri(BASE_URL + "/migrate/orders")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("COMPLETED");
    }

    @Test
    @DisplayName("Executing batch to retrieve data from MySQL 'OrderItem' table and insert into OrderItem 'User' document")
    public void testBatchJobOrderItems() throws Exception {
        webTestClient.get()
                .uri(BASE_URL + "/migrate/orderItems")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("COMPLETED");
    }
}


