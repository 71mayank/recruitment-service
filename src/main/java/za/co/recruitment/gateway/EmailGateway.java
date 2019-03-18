package za.co.recruitment.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailGateway {
    public void sendEmailNotification(String candidateEmail, String newStatus){
        //  TODO Design a template and use String formatting to build email content dynamically.
        log.info("Email Notification has been sent to user {} with the new status {} ",candidateEmail,newStatus);
    }

}
