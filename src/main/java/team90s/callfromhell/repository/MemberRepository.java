package team90s.callfromhell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import team90s.callfromhell.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
