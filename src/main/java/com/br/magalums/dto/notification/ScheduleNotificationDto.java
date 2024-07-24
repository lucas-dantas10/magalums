package com.br.magalums.dto.notification;

import com.br.magalums.entity.Channel;
import com.br.magalums.entity.Notification;
import com.br.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                message(),
                destination(),
                channel().toChannel(),
                dateTime(),
                Status.Values.PENDING.toStatus()
        );
    }
}
