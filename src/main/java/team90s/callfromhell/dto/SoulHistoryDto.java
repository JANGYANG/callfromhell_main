package team90s.callfromhell.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import team90s.callfromhell.entity.Member;
import team90s.callfromhell.entity.MissionLevel;
import team90s.callfromhell.entity.SoulHistory;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SoulHistoryDto {

    private Long soulHistoryId;

    private Long memberId;

    private Boolean plusYn;

    private Integer count;

    private Boolean status;

    private LocalDateTime createdTime;

    private LocalDateTime updateTime;

    public SoulHistoryDto(SoulHistory soulHistory){

        this.soulHistoryId = soulHistory.getSoulHistoryId();

        this.memberId = soulHistory.getMember().getMemberId();

        this.plusYn = soulHistory.getPlusYn();

        this.count = soulHistory.getCount();

        this.status = soulHistory.getStatus();

        this.createdTime = soulHistory.getCreatedTime();

        this.updateTime = soulHistory.getUpdateTime();

    }
}
