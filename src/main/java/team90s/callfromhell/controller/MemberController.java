package team90s.callfromhell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team90s.callfromhell.dto.MemberDto;
import team90s.callfromhell.service.MemberService;

@Slf4j
@RestController("member")
@RequestMapping(path = "member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping(name="test",path = "test")
    public String test(){
        log.info("TEST");
        return "YAHO";
    }

    @PostMapping(name="register",path = "register")
    public String registerMember(@RequestBody MemberDto memberDto){
        log.info("registerMember Test");
        memberService.createMemeber(memberDto.getFirstNm(), memberDto.getLastNm(), memberDto.getPhoneNm());
        return "registerMember";
    }



}
