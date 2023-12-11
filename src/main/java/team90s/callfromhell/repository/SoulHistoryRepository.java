package team90s.callfromhell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team90s.callfromhell.entity.Member;
import team90s.callfromhell.entity.SoulHistory;

import java.util.List;

public interface SoulHistoryRepository extends JpaRepository<SoulHistory, Long> {
    public List<SoulHistory> findAllByMember(Member member);
}
