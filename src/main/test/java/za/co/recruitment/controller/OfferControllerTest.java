package za.co.recruitment.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.co.recruitment.service.impl.OfferServiceImpl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfferControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    OfferController offerController;

    @MockBean
    OfferServiceImpl offerServiceImpl;

    private final static String OFFER_INBOUD_PAYLOAD = "{\n" +
            "  \"jobTitle\": \"SDE\",\n" +
            "  \"numberOfApplications\": 3,\n" +
            "  \"startDate\": \"2019-03-18T21:22:58.869Z\"\n" +
            "}";


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(offerController)
                .build();
    }

    @Test
    public void testCreateJobOfferOk() throws Exception {
        mockMvc.perform(post("/offer/createJobOffer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(OFFER_INBOUD_PAYLOAD))
                .andExpect(status().isOk());

    }

    @Test
    public void testCreateJobOfferInternalServerError() throws Exception {
        mockMvc.perform(post("/offer/createJobOffer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(""))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testGetJobOfferOk() throws Exception {
        mockMvc.perform(get("/offer/getOfferById?offerId=1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetJobOfferNotFound() throws Exception {
        mockMvc.perform(get("/offer")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    //TODO REST ENDPOINTS TEST TO BE COVERED IN THE SAME MANNER INCLUDING ALL KIND OF INPUT - BAD REQUEST AND

}
