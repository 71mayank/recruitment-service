package za.co.recruitment.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.recruitment.outbound.OfferOutboundPayload;
import za.co.recruitment.service.impl.OfferServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfferServiceImplIntegrationTest {

    @Autowired
    OfferServiceImpl offerServiceImpl;

    @Test
    public void testGetOfferByIdPositive() {
        ResponseEntity<OfferOutboundPayload> offerById = offerServiceImpl.getOfferById(1L);
        OfferOutboundPayload offerOutboundPayload = offerById.getBody();
        assertThat(offerById.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(offerOutboundPayload).isNotNull();
    }


    @Test
    public void testGetOfferByIdNegative() {
        ResponseEntity<OfferOutboundPayload> offerById = offerServiceImpl.getOfferById(0L);
        OfferOutboundPayload offerOutboundPayload = offerById.getBody();
        assertThat(offerById.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(offerOutboundPayload).isNotNull();
        assertThat(offerOutboundPayload.getResponseMessage()).isEqualTo("No value present");
    }

    //TODO Cover all functions from offerServiceImpl


}
