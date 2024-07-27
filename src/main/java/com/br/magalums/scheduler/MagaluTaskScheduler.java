package com.br.magalums.scheduler;

import com.br.magalums.service.notification.NotificationServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluTaskScheduler {

    private static final Logger logger = LoggerFactory
            .getLogger(MagaluTaskScheduler.class);

    private final NotificationServiceInterface notificationService;

    public MagaluTaskScheduler(NotificationServiceInterface notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {
        LocalDateTime dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);

        notificationService.check(dateTime);

        logger.info("Ñotification sent at {}", dateTime);
    }
}
