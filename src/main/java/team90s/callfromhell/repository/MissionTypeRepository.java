package team90s.callfromhell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team90s.callfromhell.entity.Member;
import team90s.callfromhell.entity.MissionType;

public interface MissionTypeRepository extends JpaRepository<MissionType, Long> {

}
