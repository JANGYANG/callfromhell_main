package team90s.callfromhell.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class SoulHistory {

    @Id
    @GeneratedValue
    private Long soulHistoryId;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @Column
    private Boolean plusYn;

    @Column
    private Integer count;

    @Builder.Default
    @Column(name = "status", columnDefinition = "boolean default false")
    private Boolean status = true;

    @Column
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateTime;

}
