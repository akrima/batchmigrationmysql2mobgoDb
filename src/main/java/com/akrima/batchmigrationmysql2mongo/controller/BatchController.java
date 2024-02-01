package com.akrima.batchmigrationmysql2mongo.controller;

import com.akrima.batchmigrationmysql2mongo.configuration.BatchJobHelper;
import com.akrima.batchmigrationmysql2mongo.configuration.BatchJobStatus;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/batch")
public class BatchController {

    private final JobLauncher jobLauncher;
    private final MongoTemplate mongoTemplate;

    private final Job productJob;
    private final Job userJob;
    private final Job addressJob;
    private final Job commentJob;
    private final Job orderJob;
    private final Job orderItemJob;

    @Autowired
    public BatchController(
            JobLauncher jobLauncher,
            MongoTemplate mongoTemplate,
            @Qualifier("productJob") Job productJob,
            @Qualifier("userJob") Job userJob,
            @Qualifier("addressJob") Job addressJob,
            @Qualifier("commentJob") Job commentJob,
            @Qualifier("orderJob") Job orderJob,
            @Qualifier("orderItemJob")  Job orderItemJob) {
        this.jobLauncher = jobLauncher;
        this.mongoTemplate = mongoTemplate;

        this.productJob = productJob;
        this.userJob = userJob;
        this.addressJob = addressJob;
        this.commentJob = commentJob;
        this.orderJob = orderJob;
        this.orderItemJob = orderItemJob;
    }

    @GetMapping("/migrate/products")
    public BatchJobStatus migrateProducts() throws Exception {
        return BatchJobHelper.run(productJob, jobLauncher);
    }

    @GetMapping("/migrate/users")
    public BatchJobStatus migrateUsers() throws Exception {
        return BatchJobHelper.run(userJob, jobLauncher);
    }
    @GetMapping("/migrate/address")
    public BatchJobStatus migrateAddress() throws Exception {
        return BatchJobHelper.run(addressJob, jobLauncher);
    }
    @GetMapping("/migrate/comments")
    public BatchJobStatus migrateComments() throws Exception {
        return BatchJobHelper.run(commentJob, jobLauncher);
    }

    @GetMapping("/migrate/orders")
    public BatchJobStatus migrateOrders() throws Exception {
        return BatchJobHelper.run(orderJob, jobLauncher);
    }

    @GetMapping("/migrate/orderItems")
    public BatchJobStatus migrateOrderItems() throws Exception {
        return BatchJobHelper.run(orderItemJob, jobLauncher);
    }

}

