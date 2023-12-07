package team90s.callfromhell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team90s.callfromhell.dto.MemberDto;
import team90s.callfromhell.dto.ResponseDto;
import team90s.callfromhell.service.MemberService;

@Slf4j
@RequiredArgsConstructor
@RestController("member")
@RequestMapping(path = "member")
public class MemberController {

    
    private final MemberService memberService;
    private final SmsService smsService;

    @PostMapping(name="test",path = "test")
    public String test(){
        log.info("TEST");
        return "YAHO";
    }

    @PostMapping(name="join",path = "join")
    public ResponseDto joinMember(@RequestBody MemberDto memberDto){
        log.info("registerMember Test");
        ResponseDto responseDto = ResponseDto.builder().successYn(false).build();

        try {
            memberService.createMemeber(memberDto.getFirstNm(), memberDto.getLastNm(), memberDto.getPhoneNm());
            responseDto.setSuccessYn(true);
        }catch (Exception e){
            log.error("{}",e);
            responseDto.setMessage("Member Join Failed");
        }

        return responseDto;
    }

    @PostMapping(name="getRandomNum",path = "getRandomNum")
    public ResponseDto getRandomNum(@RequestBody MemberDto memberDto){
        log.info("registerMember Test");
        ResponseDto responseDto = ResponseDto.builder().successYn(false).build();

        try {

            double min = 100000;
            double max = 999999;
            Integer randomNum = (int) ((Math.random() * (max - min)) + min);

            smsService.sendSms(memberDto.getPhoneNm(), String.format("[%d]", randomNum));

            responseDto.setSuccessYn(true);
            responseDto.setMessage(randomNum.toString());
            
        }catch (Exception e){
            log.error("{}",e);
            responseDto.setMessage("GetRandomNum Failed");
        }

        return responseDto;
    }


}
