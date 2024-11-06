package com.multitenancy.sso.entity;


import com.multitenancy.sso.audit.AuditTrailListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tenant_config")
@EntityListeners(AuditTrailListener.class)
public class TenantConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 1052202961283396511L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "db_url")
    private String dbUrl;

    @Column(name = "db_username")
    private String dbUsername;

    @Column(name = "db_password")
    private String dbPassword;

    @Column(name = "db_driver")
    private String dbDriver;
}
