package team90s.callfromhell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team90s.callfromhell.entity.MissionLevel;
import team90s.callfromhell.entity.MissionType;

public interface MissionLevelRepository extends JpaRepository<MissionLevel, Long> {

}
