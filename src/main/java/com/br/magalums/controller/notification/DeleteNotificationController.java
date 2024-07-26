package com.br.magalums.controller.notification;

import com.br.magalums.entity.Notification;
import com.br.magalums.service.notification.NotificationServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class DeleteNotificationController {

    private final NotificationServiceInterface notificationService;

    public DeleteNotificationController(NotificationServiceInterface notificationService) {
        this.notificationService = notificationService;
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long notificationId) {
        Optional<Notification> notification = this.notificationService.cancelNotification(notificationId);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
