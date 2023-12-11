package team90s.callfromhell.dto;

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
import team90s.callfromhell.entity.MissionType;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionTypeDto {

    private Long missionTypeId;

    private String missionTypeEng;

    private String missionTypeKor;


    public MissionTypeDto(MissionType missionType){

        this.missionTypeId = missionType.getMissionTypeId();

        this.missionTypeEng = missionType.getMissionTypeEng();

        this.missionTypeKor = missionType.getMissionTypeKor();

    }

}
