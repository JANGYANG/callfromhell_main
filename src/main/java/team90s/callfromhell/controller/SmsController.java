package team90s.callfromhell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team90s.callfromhell.dto.MemberDto;
import team90s.callfromhell.dto.SmsDto;
import team90s.callfromhell.service.MemberService;
import team90s.callfromhell.service.SmsService;

@Slf4j
@RestController("sms")
@RequestMapping(path = "sms")
public class SmsController {

    @Autowired
    MemberService memberService;

    @Autowired
    SmsService smsService;


    @PostMapping(name="test",path = "test")
    public String test(){
        log.info("TEST");
        return "YAHO";
    }

    @PostMapping(name="send",path = "send")
    public String sendSms(@RequestBody SmsDto smsDto){

        smsService.sendSms(smsDto.getPhoneNum(), "CONTENT");
        return "registerMember";

    }



}
