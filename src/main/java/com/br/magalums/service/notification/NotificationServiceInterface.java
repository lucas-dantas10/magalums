package com.br.magalums.service.notification;

import com.br.magalums.dto.notification.ScheduleNotificationDto;

public interface NotificationServiceInterface {
    void scheduleNotification(ScheduleNotificationDto dto);
}
