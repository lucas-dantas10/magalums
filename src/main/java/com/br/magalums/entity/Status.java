package com.br.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long statusId;

    private String description;

    public Status() {
    }

    public Status(Long id, String description) {
        this.statusId = id;
        this.description = description;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        PENDING(1L, "pending"),
        SUCCESS(2L, "success"),
        ERROR(3L, "error"),
        CANCELLED(4L, "cancelled");

        private final Long id;
        private final String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Status toStatus() {
            return new Status(this.id, this.description);
        }
    }
}
