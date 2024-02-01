
```markdown
# Batch Migration from MySQL to MongoDB

## Overview

This project is a Spring Boot application designed to migrate data from MySQL to MongoDB using Spring Batch.

## Project Structure

```
├───main
│   ├───java
│   │   └───com
│   │       └───akrima
│   │           └───batchmigrationmysql2mongo
│   │               │   App.java
│   │               │
│   │               ├───configuration
│   │               │   │   AddressBatchConfig.java
│   │               │   │   BatchConfig.java
│   │               │   │   BatchJobHelper.java
│   │               │   │   BatchJobStatus.java
│   │               │   │   CommentBatchConfig.java
│   │               │   │   OrderBatchConfig.java
│   │               │   │   OrderItemBatchConfig.java
│   │               │   │   ProductBatchConfig.java
│   │               │   │   UserBatchConfig.java
│   │               │   │
│   │               │
│   │               ├───controller
│   │               │   │   BatchController.java
│   │               │   │
│   │               ├───entity
│   │               │   │
│   │               │   ├───jpa
│   │               │   │   │   AddressJpa.java
│   │               │   │   │   BaseEntity.java
│   │               │   │   │   CommentJpa.java
│   │               │   │   │   OrderItemJpa.java
│   │               │   │   │   OrderJpa.java
│   │               │   │   │   ProductJpa.java
│   │               │   │   │   UserJpa.java
│   │               │   │   │
│   │               │   │
│   │               │   └───mongo
│   │               │       │   AddressMongo.java
│   │               │       │   CommentMongo.java
│   │               │       │   OrderItemMongo.java
│   │               │       │   OrderMongo.java
│   │               │       │   ProductMongo.java
│   │               │       │   UserMongo.java
│   │               │
│   │               └───processor
│   │                       │   AddressItemProcessor.java
│   │                       │   CommentItemProcessor.java
│   │                       │   OrderItemItemProcessor.java
│   │                       │   OrderItemProcessor.java
│   │                       │   ProductItemProcessor.java
│   │                       │   UserItemProcessor.java
│   │
│   └───resources
│       │   application.yml
│       │
│       ├───db
│       │       data.sql
│       │       schema.sql
│       │
│       ├───static
│       └───templates
└───test
├───java
│   └───com
│       └───akrima
│           └───batchmigrationmysql2mongo
│               │   AppTest.java
│               │
│               └───integration
│                       │   BatchIntegrationTest.java
│                       │   TestDataSourceConfig.java
│
└───resources
│   test-application.yml
│
└───db
data.sql
schema.sql
```

## Setup

1. Clone the repository:

   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:

   ```bash
   cd ....
   ```

3. Build the project:

   ```bash
   ./mvnw clean install
   ```

4. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

## Testing

The project includes integration tests to verify the migration process.

To run tests:

```bash
./mvnw test
```
