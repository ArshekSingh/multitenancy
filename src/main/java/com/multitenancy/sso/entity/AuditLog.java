package com.multitenancy.sso.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit_log")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entityName;
    private Long entityId;
    private String action;
    private String entityBeforeChange;
    private String entityAfterChange;
    private LocalDateTime timestamp;

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setEntityBeforeChange(String entityBeforeChange) {
        this.entityBeforeChange = entityBeforeChange;
    }

    public void setEntityAfterChange(String entityAfterChange) {
        this.entityAfterChange = entityAfterChange;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    // Constructors, getters, setters...
}