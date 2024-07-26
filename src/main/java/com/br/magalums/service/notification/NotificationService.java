package com.br.magalums.service.notification;

import com.br.magalums.dto.notification.ScheduleNotificationDto;
import com.br.magalums.entity.Notification;
import com.br.magalums.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Notification> findbyId(Long notificationId) {
        return this.notificationRepository.findById(notificationId);
    }
}
