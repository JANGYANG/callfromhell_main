package team90s.callfromhell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team90s.callfromhell.entity.Member;
import team90s.callfromhell.entity.Wakeup;

import java.util.List;

public interface WakeupRepository extends JpaRepository<Wakeup, Long> {

    public List<Wakeup> findAllByWakeupKey(String wakeupKey);

}
