package com.br.magalums.service.notification;

import com.br.magalums.dto.notification.ScheduleNotificationDto;
import com.br.magalums.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements NotificationServiceInterface {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void scheduleNotification(ScheduleNotificationDto dto) {
        this.notificationRepository.save(dto.toNotification());
    }
}
