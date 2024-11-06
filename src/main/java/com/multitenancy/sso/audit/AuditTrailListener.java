package com.multitenancy.sso.audit;

import com.multitenancy.sso.entity.AuditLog;
import com.multitenancy.sso.repository.AuditLogRepository;
import com.multitenancy.sso.util.ObjectMapperUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PostUpdate;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Component
public class AuditTrailListener {

    private ApplicationContext context;

    public AuditTrailListener(ApplicationContext context) {
        this.context = context;
    }

    @PostUpdate
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void preUpdate(Object entity) {
        try {
            EntityManager em = context.getBean(EntityManager.class);
            Long id = getEntityId(entity);
            Object oldEntity = em.find(entity.getClass(), id);
            if (Objects.nonNull(oldEntity))
                createAuditLog(id, oldEntity, "UPDATE", entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Long getEntityId(Object entity) throws IllegalAccessException {
        Field idField = Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Entity has no ID field"));
        idField.setAccessible(true);
        return Long.valueOf(String.valueOf(idField.get(entity)));
    }

    private void createAuditLog(Long id, Object entity, String action, Object changedEntity) throws IllegalAccessException {
        AuditLog auditLog = new AuditLog();
        Object actualEntity = Hibernate.unproxy(entity);
        auditLog.setEntityName(actualEntity.getClass().getSimpleName());
        auditLog.setEntityId(id);
        auditLog.setAction(action);
        auditLog.setEntityBeforeChange(ObjectMapperUtil.asJsonString(actualEntity));
        if (action.equalsIgnoreCase("UPDATE"))
            auditLog.setEntityAfterChange(ObjectMapperUtil.asJsonString(Hibernate.unproxy(changedEntity)));
        auditLog.setTimestamp(LocalDateTime.now());
        AuditLogRepository auditLogRepository = context.getBean(AuditLogRepository.class);
        auditLogRepository.save(auditLog);
    }
}
