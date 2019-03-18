package za.co.recruitment.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import za.co.recruitment.service.impl.ApplicationServiceImpl;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServiceImplIntegrationTest {

    @Autowired
    ApplicationServiceImpl applicationServiceImpl;

    @Test
    public void testGetApplicationsByOfferIdPositive() {
        ResponseEntity<List<ApplicationOutboundPayload>> applicationsByOfferId = applicationServiceImpl.getApplicationsByOfferId(1L);
        List<ApplicationOutboundPayload> applicationOutboundPayloads = applicationsByOfferId.getBody();
        assertThat(applicationsByOfferId.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(applicationOutboundPayloads).isNotNull();
    }


    //TODO Cover all functions from applicationServiceImpl
}
