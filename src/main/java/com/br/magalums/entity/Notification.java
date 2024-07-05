package com.br.magalums.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;

    private LocalDateTime datetime;

    private String destination;

    private String message;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
