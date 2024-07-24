package com.br.magalums.controller.notification;

import com.br.magalums.dto.notification.ScheduleNotificationDto;
import com.br.magalums.service.notification.NotificationServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class PostScheduleNotificationController {

    private final NotificationServiceInterface notificationService;

    public PostScheduleNotificationController(NotificationServiceInterface notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        this.notificationService.scheduleNotification(dto);

        return ResponseEntity.accepted().build();
    }
}
