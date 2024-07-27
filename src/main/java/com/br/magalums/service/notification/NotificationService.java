package com.br.magalums.service.notification;

import com.br.magalums.dto.notification.ScheduleNotificationDto;
import com.br.magalums.entity.Notification;
import com.br.magalums.entity.Status;
import com.br.magalums.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

    @Override
    public Optional<Notification> cancelNotification(Long notificationId) {
        Optional<Notification> notification = findbyId(notificationId);

        if (notification.isEmpty()) {
            return notification;
        }

        notification.get().setStatus(Status.Values.CANCELLED.toStatus());
        notificationRepository.save(notification.get());

        return notification;
    }

    @Override
    public void check(LocalDateTime datetime) {
        List<Notification> notifications = this.notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()),
                datetime);

        send(notifications);
    }

    @Override
    public void send(List<Notification> notifications) {
        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            //TODO - ENVIAR NOTIFICACAO

            notification.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(notification);
        };
    }
}
