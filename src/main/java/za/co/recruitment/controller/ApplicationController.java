package za.co.recruitment.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import za.co.recruitment.service.impl.ApplicationServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("application")
@Api(value = "Application Service ", description = "Operations related to job application")
public class ApplicationController {

    @Autowired
    ApplicationServiceImpl applicationServiceImpl;


    @ApiOperation(value = "Apply for an offer", response = ApplicationOutboundPayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully applied for an offer"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict - Candidate email already found for this offer")
    })
    @PostMapping(value = "/applyForAnOffer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationOutboundPayload> applyForAnOffer(@Valid @RequestBody ApplicationInboundPayload applicationInboundPayload) {
        return applicationServiceImpl.applyForAnOffer(applicationInboundPayload);
    }


    @ApiOperation(value = "Read single application per offer", response = ApplicationOutboundPayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all offer"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/listApplicationPerOffer")
    public ResponseEntity<ApplicationOutboundPayload> listApplicationPerOffer(@ApiParam(value = "offerId", required = true)
                                                                              @RequestParam(value = "offerId") Long offerId,
                                                                              @ApiParam(value = "applicationId", required = true)
                                                                              @RequestParam(value = "applicationId") Long applicationId) {
        return applicationServiceImpl.getApplicationByIdPerOffer(applicationId, offerId);
    }

    @ApiOperation(value = "List all applications per offer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all applications per offer"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/listAllApplicationsPerOffer")
    public ResponseEntity<List<ApplicationOutboundPayload>> listAllApplicationsPerOffer(@ApiParam(value = "offerId", required = true)
                                                                                        @RequestParam(value = "offerId") Long offerId) {
        return applicationServiceImpl.getApplicationsByOfferId(offerId);
    }


    @ApiOperation(value = "List all existing applications", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all applications")
    })
    @GetMapping("/trackAllApplications")
    public ResponseEntity<List<ApplicationOutboundPayload>> getAllApplications() {
        return applicationServiceImpl.getAllApplications();
    }

    @ApiOperation(value = "Update application status", response = ApplicationOutboundPayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated applications status for candidate"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PutMapping("/updateApplicationStatus/{applicationId}")
    public ResponseEntity<ApplicationOutboundPayload> updateApplicationStatus(@Valid @RequestParam String newApplicationStatus, @PathVariable Long applicationId) {
        return applicationServiceImpl.updateApplicationStatus(newApplicationStatus, applicationId);
    }

}