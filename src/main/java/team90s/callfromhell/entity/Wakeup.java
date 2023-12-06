package team90s.callfromhell.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Wakeup {

    @Id
    private String wakeupId;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @Column
    private String phoneNumTo;

    @Column
    private LocalDateTime wakeupTime;

    @Builder.Default
    @Column(name = "successYn", columnDefinition = "boolean default false")
    private Boolean successYn = false;

    @Column
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateTime;


}
