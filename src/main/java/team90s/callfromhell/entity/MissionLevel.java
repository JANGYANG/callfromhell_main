package team90s.callfromhell.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class MissionLevel {

    @Id
    private Long missionLevelId;

    @Column
    private String missionLevel;

    @Column
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateTime;
}
