package com.demo.app.ws.dao.entities;

import com.demo.app.ws.shared.utils.EntityUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseEntity{
    @Id
    @GeneratedValue
    protected long id;

    @Column(length = 64, nullable = false)
    protected String publicId;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @PrePersist
    private void prePersistFunction(){
        publicId = EntityUtils.generateStrongId(32);
    }


}
