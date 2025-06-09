package com.mealmate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public abstract class  BaseEntity {
    @CreatedDate
    @Column(name = "creation_time", updatable = false,nullable = false)
    private LocalDateTime creationTime;
    @LastModifiedDate
    @Column(name = "updated_at",insertable = false)
    private LocalDateTime updatedTime;
    @CreatedBy
    @Column(name = "created_by",nullable = false,updatable = false)
    private String createdBy;
    @LastModifiedBy
    @Column(name = "updated_by",insertable = false)
    private String updatedBy;


}
