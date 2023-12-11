package team90s.callfromhell.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team90s.callfromhell.dto.SoulHistoryDto;
import team90s.callfromhell.entity.SoulHistory;
import team90s.callfromhell.repository.MemberRepository;
import team90s.callfromhell.repository.SoulHistoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SoulService {

    private final SoulHistoryRepository soulHistoryRepository;
    private final MemberRepository memberRepository;


    public List<SoulHistoryDto> getSoulHistory(Long memberId){

        List<SoulHistoryDto> soulHistoryDtos = new ArrayList<>();

        soulHistoryRepository.findAllByMember(memberRepository.getReferenceById(memberId)).stream().forEach(soulHistory -> soulHistoryDtos.add(new SoulHistoryDto(soulHistory)));

        return soulHistoryDtos;

    }

    public Integer getTotalSoulCount(Long memberId){

        Integer soulTotal = 0;

        List<SoulHistory> soulHistories = soulHistoryRepository.findAllByMember(memberRepository.getReferenceById(memberId)).stream().filter(soulHistory -> soulHistory.getStatus()).collect(Collectors.toList());

        for(SoulHistory soulHistory : soulHistories){
            if(soulHistory.getPlusYn()){
                // Plus
                soulTotal += soulHistory.getCount();
            }else{
                // Minus
                soulTotal -= soulHistory.getCount();
            }
        }

        return soulTotal;

    }

    public Boolean plusSoulCount(Long memberId, Integer soulCount){
        try{
            soulHistoryRepository.save(SoulHistory.builder().member(memberRepository.getReferenceById(memberId)).plusYn(true).count(soulCount).build());
            return true;
        }catch (Exception e){
            log.error("{}", e);
            return false;
        }
    }
    public Boolean minusSoulCount(Long memberId, Integer soulCount){
        try{
            soulHistoryRepository.save(SoulHistory.builder().member(memberRepository.getReferenceById(memberId)).plusYn(false).count(soulCount).build());
            return true;
        }catch (Exception e){
            log.error("{}", e);
            return false;
        }
    }

}
