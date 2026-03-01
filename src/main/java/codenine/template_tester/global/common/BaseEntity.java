package codenine.template_tester.global.common;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //자식 entity 컬럼으로 포함됨
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate //insert 시 시간 저장
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate //update 시 자동 변경
    private LocalDateTime updatedAt;
}
