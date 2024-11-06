package com.multitenancy.sso.entity;

import com.multitenancy.sso.audit.AuditTrailListener;
import com.multitenancy.sso.enums.DepartmentName;
import com.multitenancy.sso.enums.RoleType;
import com.multitenancy.sso.util.Constants;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditTrailListener.class)
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = -7115495549710070207L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String roleName;
    private int businessId;
    @Enumerated(EnumType.ORDINAL)
    private DepartmentName department;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @ManyToMany
    @JoinTable(name = "role_permission_link", joinColumns = @JoinColumn(name = Constants.ROLE_ID), inverseJoinColumns = @JoinColumn(name = Constants.PERMISSION_ID))
    private Set<Permission> rolePermissions;
}
