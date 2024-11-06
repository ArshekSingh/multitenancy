package com.multitenancy.sso.entity;

import com.multitenancy.sso.audit.AuditTrailListener;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditTrailListener.class)
public class Permission implements Serializable {

    @Serial
    private static final long serialVersionUID = 4855747259102010788L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;

    private String permissionName;
}
