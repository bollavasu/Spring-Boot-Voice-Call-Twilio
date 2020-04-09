package com.journaldev.spring;

import java.net.URI;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class VoicedemoApplication implements ApplicationRunner {
   private final static String ACCOUNT_SID = "ACCOUNT_SID";
   private final static String AUTH_ID = "AUTH_ID";

   static {
      Twilio.init(ACCOUNT_SID, AUTH_ID);
   }
   public static void main(String[] args) {
      SpringApplication.run(VoicedemoApplication.class, args);
   }
   @Override
   public void run(ApplicationArguments arg0) throws Exception {
      Call.creator(new PhoneNumber("+918333069787"), new PhoneNumber("+918333069787"),
         new URI("http://demo.twilio.com/docs/voice.xml")).create();
   }
}
