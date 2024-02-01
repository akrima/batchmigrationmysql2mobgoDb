package com.akrima.batchmigrationmysql2mongo.configuration;

import java.time.LocalDateTime;

public record BatchJobStatus(
        String status,
        String exitStatus,
        LocalDateTime startTime,
        LocalDateTime endTime,
        LocalDateTime lastUpdated
) {
}
