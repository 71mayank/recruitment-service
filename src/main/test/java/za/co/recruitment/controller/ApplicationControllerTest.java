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
import za.co.recruitment.service.impl.ApplicationServiceImpl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    ApplicationController applicationController;

    @MockBean
    ApplicationServiceImpl applicationServiceImpl;

    private final static String APPLICATION_INBOUD_PAYLOAD = "{\n" +
            "  \"relatedOffer\": 3,\n" +
            "  \"candidateEmail\": \"71mayank@gmail.com\",\n" +
            "  \"resumeText\": \"This is my Resume\",\n" +
            "  \"applicationStatus\": \"APPLIED\"\n" +
            "}";


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(applicationController)
                .build();
    }

    @Test
    public void testApplyForAnOfferOk() throws Exception {
        mockMvc.perform(post("/application/applyForAnOffer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(APPLICATION_INBOUD_PAYLOAD))
                .andExpect(status().isOk());

    }

    @Test
    public void testApplyForAnOfferInternalServerError() throws Exception {
        mockMvc.perform(post("/application/applyForAnOffer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(""))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testListApplicationPerOfferOk() {
        //TODO THIS TEST Needs to be completed
    }

    @Test
    public void testListApplicationPerOfferNegative() {
        //TODO THIS TEST Needs to be completed
    }

    @Test
    public void testListAllApplicationsPerOfferPositive() {
        //TODO THIS TEST Needs to be completed
    }

    @Test
    public void testListAllApplicationsPerOfferNegative()  {
        //TODO THIS TEST Needs to be completed
    }


    @Test
    public void testGetAllApplicationsPositive()  {
        //TODO THIS TEST Needs to be completed
    }

    @Test
    public void testGetAllApplicationsNegative()  {
        //TODO THIS TEST Needs to be completed
    }

    @Test
    public void testUpdateApplicationStatusPositive()  {
        //TODO THIS TEST Needs to be completed
    }

    @Test
    public void testUpdateApplicationStatusNegative()  {
        //TODO THIS TEST Needs to be completed
    }

}
