package team90s.callfromhell.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team90s.callfromhell.dto.MessageDto;
import team90s.callfromhell.dto.ResponseDto;
import team90s.callfromhell.dto.SmsDto;
import team90s.callfromhell.dto.WakeupDto;
import team90s.callfromhell.entity.Wakeup;
import team90s.callfromhell.service.ActiveMqService;
import team90s.callfromhell.service.MemberService;
import team90s.callfromhell.service.SmsService;
import team90s.callfromhell.service.WakeupService;

@Slf4j
@RestController("wakeup")
@RequiredArgsConstructor
@RequestMapping(path = "wakeup")
public class WakeUpController {

    //@Autowired
    MemberService memberService;

    //@Autowired
    SmsService smsService;

    //@Autowired
    private final ActiveMqService activeMqService;
    private final WakeupService wakeupService;

    @PostMapping(name="start",path = "start")
    public ResponseDto start(@RequestBody WakeupDto wakeupDto){

        log.info("wakeUp start. Incoming Data : [{}]", wakeupDto);

        ResponseDto responseDto = ResponseDto.builder().successYn(false).build();

        try {
            wakeupService.wakeupStart(wakeupDto);
            responseDto.setSuccessYn(true);
        }catch (Exception e){
            log.error("{}",e);
            responseDto.setMessage("WakeupStart failed");
        }

        return responseDto;
        
    }

    @PostMapping(name="end",path = "end")
    public ResponseDto end(@RequestBody WakeupDto wakeupDto){

        log.info("wakeUp start. Incoming Data : [{}]", wakeupDto);

        ResponseDto responseDto = ResponseDto.builder().successYn(false).build();

        try {
            wakeupService.wakeupEnd(wakeupDto);
            responseDto.setSuccessYn(true);
        }catch (Exception e){
            responseDto.setMessage("WakeupStart failed");
        }

        return responseDto;

    }

}
