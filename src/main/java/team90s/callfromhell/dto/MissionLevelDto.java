package team90s.callfromhell.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import team90s.callfromhell.entity.MissionLevel;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionLevelDto {

    private Long missionLevelId;

    private String missionLevelEng;

    private String missionLevelKor;

    public MissionLevelDto(MissionLevel missionLevel){
        this.missionLevelId = missionLevel.getMissionLevelId();
        this.missionLevelEng = missionLevel.getMissionLevelEng();
        this.missionLevelKor = missionLevel.getMissionLevelKor();
    }
}
