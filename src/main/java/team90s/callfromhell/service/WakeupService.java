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
import team90s.callfromhell.entity.Member;
import team90s.callfromhell.entity.Wakeup;
import team90s.callfromhell.repository.MemberRepository;
import team90s.callfromhell.repository.WakeupRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class WakeupService {

    private final WakeupRepository wakeupRepository;
    private final MemberRepository memberRepository;

    private final ActiveMqService activeMqService;
    private final SmsService smsService;
    private final MemberService memberService;

    public void wakeupStart(WakeupDto wakeupDto){
        log.info("wakeupStart CALLED");

        for(String phoneNum : wakeupDto.getPhoneNmTo()){

            Wakeup wakeup = Wakeup.builder()
                    .wakeupKey(wakeupDto.getWakeupKey())
                    .wakeupTime(wakeupDto.getWakeupTime())
                    .member(memberRepository.getReferenceById(wakeupDto.getMemberId()))
                    .phoneNumTo(phoneNum)
                    .build();

            wakeupRepository.save(wakeup);
            log.info("DB SAVED {}", wakeup);
        }




        activeMqService.sendWakeup(wakeupDto);
        log.info("Queue Sent {}", wakeupDto);

    }

    public void wakeupEnd(WakeupDto wakeupDto){
        log.info("wakeupEnd CALLED");

        List<Wakeup> wakeupSearchResults = wakeupRepository.findAllByWakeupKey(wakeupDto.getWakeupKey());

        for(Wakeup wakeup : wakeupSearchResults){
            wakeup.setSuccessYn(true);
            wakeupRepository.save(wakeup);
        }

    }


    @JmsListener(destination = "${activemq.queue.name}", selector = "")
    public void receiveMessage(WakeupDto wakeupDto) {
        log.info("Queue is Received. Data is [{}]",wakeupDto);
        checkWakeupSuccess(wakeupDto);
    }

    public void checkWakeupSuccess(WakeupDto wakeupDto){

        List<Wakeup> wakeupSearchResults = wakeupRepository.findAllByWakeupKey(wakeupDto.getWakeupKey());

        for(Wakeup wakeup : wakeupSearchResults){
            if(wakeup.getSuccessYn()){
                log.info("Mission Success. SMS is not sent. Data is [{}]", wakeupDto);
            }else{
                log.info("Mission Failed. SMS will be sent. Data is [{}]", wakeupDto);

                Member member = memberService.getMemberById(wakeupDto.getMemberId());

                String content = String.format("This is from %s %s. Wakeup Time is %s",member.getLastNm(), member.getFirstNm(), wakeupDto.getWakeupTime().toString());

                smsService.sendSms(wakeup.getPhoneNumTo(), content);
                log.info("SMS is sent. Content is [{}]", content);
            }
        }
    }

}
