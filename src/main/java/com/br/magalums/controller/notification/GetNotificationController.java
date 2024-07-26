package com.br.magalums.controller.notification;

import com.br.magalums.entity.Notification;
import com.br.magalums.service.notification.NotificationServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class GetNotificationController {

    private final NotificationServiceInterface notificationService;

    public GetNotificationController(NotificationServiceInterface notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long notificationId) {
        Optional<Notification> notification = this.notificationService.findbyId(notificationId);

        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
