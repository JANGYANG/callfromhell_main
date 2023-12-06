package team90s.callfromhell.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import team90s.callfromhell.dto.MessageDto;
import team90s.callfromhell.dto.WakeupDto;
import team90s.callfromhell.entity.Wakeup;
import team90s.callfromhell.repository.MemberRepository;
import team90s.callfromhell.repository.WakeupRepository;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class WakeupService {

    private final WakeupRepository wakeupRepository;
    private final MemberRepository memberRepository;

    private final ActiveMqService activeMqService;

    public void wakeupStart(WakeupDto wakeupDto){
        log.info("wakeupStart CALLED");

        Wakeup wakeup = wakeupRepository.save(Wakeup.builder().wakeupId(wakeupDto.getWakeupId()).member(memberRepository.getReferenceById(wakeupDto.getMemberId())).phoneNumTo(wakeupDto.getPhoneNmTo()).build());
        log.info("DB SAVED {}", wakeup);

        activeMqService.sendWakeup(wakeupDto);
        log.info("Queue Sent {}", wakeupDto);

    }

    public void wakeupEnd(WakeupDto wakeupDto){
        log.info("wakeupEnd CALLED");

        Optional<Wakeup> wakeupSearchResult = wakeupRepository.findById(wakeupDto.getWakeupId());

        if(wakeupSearchResult.isPresent()){

            Wakeup wakeup = wakeupSearchResult.get();
            wakeup.setSuccessYn(true);
            wakeupRepository.save(wakeup);

        }else{
            wakeupRepository.save(Wakeup.builder().wakeupId(wakeupDto.getWakeupId()).successYn(true).phoneNumTo(wakeupDto.getPhoneNmTo()).member(memberRepository.getReferenceById(wakeupDto.getMemberId())).build());
        }

    }

}
