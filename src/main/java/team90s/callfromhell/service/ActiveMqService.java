package team90s.callfromhell.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;
import team90s.callfromhell.dto.MessageDto;
import team90s.callfromhell.dto.WakeupDto;
import team90s.callfromhell.entity.Member;
import team90s.callfromhell.entity.Wakeup;
import team90s.callfromhell.repository.WakeupRepository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ActiveMqService {

    private final SmsService smsService;
    private final MemberService memberService;
    private final WakeupRepository wakeupRepository;


    @Value("${activemq.queue.name}")
    private String queueName;

    @Value("${activemq.queue.delay}")
    private Long delayTime;

    // jmsTemplate 을 통해 메세지 송신 가능
    private final JmsTemplate jmsTemplate;

    /**
     * Queue 로 메세지를 발행
     * messageDto -> Producer 가 Queue 발행한 메세지 Class
     */
    public void sendMessage(MessageDto messageDto) {
        log.info("message sent : {}", messageDto.toString());
        // queueName(Sample-queue) 에 메세지 전송

        jmsTemplate.convertAndSend(queueName,messageDto, message -> {

            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delayTime);

            return message;

        });

    }

    public void sendWakeup(WakeupDto wakeupDto) {


        jmsTemplate.convertAndSend(queueName,wakeupDto, message -> {

            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delayTime);

            return message;
        });

    }

    @JmsListener(destination = "${activemq.queue.name}", selector = "")
    public void receiveMessage(WakeupDto wakeupDto) {

        log.info("Queue is Received. Data is [{}]",wakeupDto);

        Optional<Wakeup> searchResult = wakeupRepository.findById(wakeupDto.getWakeupId());

        if(searchResult.isPresent() && searchResult.get().getSuccessYn()){

            log.info("Mission Success. SMS is not sent. Data is [{}]", wakeupDto);

        }else{
            log.info("Mission Failed. SMS will be sent. Data is [{}]", wakeupDto);

            Member member = memberService.getMemberById(wakeupDto.getMemberId());

            String content = "This is from " + member.getLastNm() +" "+ member.getFirstNm();

            smsService.sendSms(wakeupDto.getPhoneNmTo(), content);
        }

    }


}
