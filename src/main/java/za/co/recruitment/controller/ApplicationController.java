package za.co.recruitment.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import za.co.recruitment.service.impl.ApplicationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("application")
@Api(value = "Application Service ", description = "Operations related to job application")
public class ApplicationController {

    @Autowired
    ApplicationServiceImpl applicationService;


    @ApiOperation(value = "Apply for an offer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created offer"),
            @ApiResponse(code = 401, message = "You are not authorized to add offer"),
            @ApiResponse(code = 403, message = "Access to the offer you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The offer you were trying to reach is not found")
    })
    @PostMapping(value = "/applyForAnOffer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationOutboundPayload> applyForAnOffer(@RequestBody ApplicationInboundPayload applicationInboundPayload) {
        return new ResponseEntity<>((ApplicationOutboundPayload) null, HttpStatus.OK);
    }


    @ApiOperation(value = "Read one application per offer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all offer"),
            @ApiResponse(code = 403, message = "Access to the application you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The application you were trying to find is not found")
    })
    @GetMapping("/listApplicationPerOffer")
    public ResponseEntity<ApplicationOutboundPayload> listApplicationPerOffer(@ApiParam(value = "offerId", required = true)
                                                                              @RequestParam(value = "offerId") Long offerId,
                                                                              @ApiParam(value = "applicationId", required = true)
                                                                              @RequestParam(value = "applicationId") Long applicationId) {
        return new ResponseEntity<>((ApplicationOutboundPayload) null, HttpStatus.OK);
    }

    @ApiOperation(value = "List all applications per offer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all applications per offer"),
            @ApiResponse(code = 403, message = "Access to the application you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The application you were trying to find is not found")
    })
    @GetMapping("/listAllApplicationsPerOffer")
    public ResponseEntity<ApplicationOutboundPayload> listAllApplicationsPerOffer(@ApiParam(value = "offerId", required = true)
                                                                                  @RequestParam(value = "offerId") Long offerId) {
        return new ResponseEntity<>((ApplicationOutboundPayload) null, HttpStatus.OK);
    }


}