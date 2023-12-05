package team90s.callfromhell.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("twilio.user.name")
    String twilioUserName;

    @Value("twilio.user.pw")
    String twilioPw;

    public void SendSms(String phoneNum){

        Twilio.init(twilioUserName, twilioPw);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNum),
                        new com.twilio.type.PhoneNumber(phoneNum),
                        "SMS TEST")
                .create();
    }




}
