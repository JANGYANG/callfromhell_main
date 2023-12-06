package team90s.callfromhell.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsService {

    @Value("${twilio.user.name}")
    String twilioUserName;

    @Value("${twilio.user.pw}")
    String twilioPw;

    @Value("${twilio.user.phone}")
    String phoneNumFrom;

    public Message sendSms(String phoneNumTo, String content){

        Twilio.init(twilioUserName, twilioPw);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumTo),
                        new com.twilio.type.PhoneNumber(phoneNumFrom),
                        content)
                .create();

        return message;
    }


    public Message sendSms(String phoneNumTo, String phoneNumFrom, String content){
        log.info("sendSms is CALLED");


        Twilio.init(twilioUserName, twilioPw);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumTo),
                        new com.twilio.type.PhoneNumber(phoneNumFrom),
                        content)
                .create();

        log.info("sms is SENT");

        return message;
    }




}
