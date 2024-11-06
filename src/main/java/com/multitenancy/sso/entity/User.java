package com.multitenancy.sso.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.multitenancy.sso.audit.AuditTrailListener;
import com.multitenancy.sso.enums.MpinStatus;
import com.multitenancy.sso.enums.UserStatus;
import com.multitenancy.sso.enums.UserType;
import com.multitenancy.sso.util.Constants;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Accessors(chain = true)
@EntityListeners(AuditTrailListener.class)
public class User extends BaseEntity implements UserDetails {

    @Serial
    private static final long serialVersionUID = 8463665441872076965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String loggedInUserId;
    private String fullName;
    private int businessId;
    private Long mobileNumber;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime lastLoggedIn;

    @Column(nullable = true)
    private Boolean isSameAsWhatsappNumber;
    @Column(nullable = true)
    private Long whatsAppNumber;

    private String mpin;
    @Enumerated(EnumType.ORDINAL)
    private MpinStatus mpinStatus;
    private String profilePic;
    private int mpinLoginAttempts;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date lastFailedAttempt;
    private int numberOfFailedAttempts;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date passwordSetDate;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus userStatus;
    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_role_link", joinColumns = @JoinColumn(name = Constants.LOGGED_IN_USER_ID, referencedColumnName = Constants.LOGGED_IN_USER_ID), inverseJoinColumns = @JoinColumn(name = Constants.ROLE_ID, referencedColumnName = Constants.ROLE_ID))
    private Set<Role> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        setLoggedInUserId(getUsername());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        if(getUserRoles() != null) {
            for (Role role : getUserRoles()) {
                List<Permission> list = new ArrayList<>(role.getRolePermissions());
                for (Permission permission : list) {
                    authorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));
                }
            }
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return loggedInUserId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
