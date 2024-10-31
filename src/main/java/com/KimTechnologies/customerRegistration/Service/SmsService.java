package com.KimTechnologies.customerRegistration.Service;

import com.KimTechnologies.customerRegistration.Dto.MessageRequest;
import org.springframework.stereotype.Service;

@Service
public class SmsService
{
    public  void sendSms(MessageRequest messageRequest)
    {
        System.out.println("Sending Sms to" +  " "  + " " +messageRequest.getPhoneNumber());
    }
}
