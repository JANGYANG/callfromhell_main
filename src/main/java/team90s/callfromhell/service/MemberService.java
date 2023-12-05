package team90s.callfromhell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team90s.callfromhell.entity.Member;
import team90s.callfromhell.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    public void createMemeber(String firstNm, String lastNm, String phoneNb){

        Member member = Member.builder()
                .firstNm(firstNm)
                .lastNm(lastNm)
                .phoneNb(phoneNb)
                .build();

        memberRepository.save(member);

    }

}
