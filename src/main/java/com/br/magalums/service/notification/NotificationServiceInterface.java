package com.br.magalums.service.notification;

import com.br.magalums.dto.notification.ScheduleNotificationDto;
import com.br.magalums.entity.Notification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NotificationServiceInterface {
    void scheduleNotification(ScheduleNotificationDto dto);
    Optional<Notification> findbyId(Long notificationId);
    Optional<Notification> cancelNotification(Long notificationId);
    void check(LocalDateTime datetime);
    void send(List<Notification> notifications);
}
