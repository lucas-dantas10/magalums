package com.br.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_channel")
public class Channel {

    @Id
    private Long channelId;

    private String description;

    public Channel() {
    }

    public Channel(Long id, String description) {
        this.channelId = id;
        this.description = description;
    }


    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        WHATSAPP(3L, "whatsapp"),
        PUSH(4L, "push");

        private final Long id;
        private final String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {
            return new Channel(this.id, this.description);
        }

    }
}
