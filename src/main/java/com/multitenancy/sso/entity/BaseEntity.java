package com.multitenancy.sso.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.multitenancy.sso.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    protected Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    protected Date modifiedDate;

    @Column(name = "created_by")
    protected String createdBy;

    @Column(name = "modified_by")
    protected String modifiedBy;

    @Column(name = "status")

    @Enumerated(EnumType.ORDINAL)
    protected EntityStatus status;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        modifiedDate = createdDate;
        status = EntityStatus.ACTIVE;
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }
}
