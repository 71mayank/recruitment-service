package za.co.recruitment.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.recruitment.inbound.OfferInboundPayload;
import za.co.recruitment.outbound.OfferOutboundPayload;
import za.co.recruitment.service.impl.OfferServiceImpl;

import java.util.List;

@RestController
@RequestMapping("offer")
@Api(value = "Offer Service ", description = "Operations related to job offer")
public class OfferController {

    @Autowired
    OfferServiceImpl offerServiceImpl;

    @ApiOperation(value = "Add offer to the recruitment", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created offer"),
            @ApiResponse(code = 401, message = "You are not authorized to add offer"),
            @ApiResponse(code = 403, message = "Access to the offer you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The offer you were trying to reach is not found")
    })
    @PostMapping(value = "/createJobOffer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferOutboundPayload> createJobOffer(@RequestBody OfferInboundPayload offerInboundPayload) {
        return new ResponseEntity<>((OfferOutboundPayload) null, HttpStatus.OK);
    }

    @ApiOperation(value = "Read a single offer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved offer"),
            @ApiResponse(code = 403, message = "Access to the offer you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The offer you were trying to reach is not found")
    })
    @GetMapping("/getOfferById")
    public ResponseEntity<OfferOutboundPayload> getOfferById(@ApiParam(value = "offerId", required = true)
                                                             @RequestParam(value = "offerId") Long offerId) {
        return new ResponseEntity<>((OfferOutboundPayload) null, HttpStatus.OK);
    }

    @ApiOperation(value = "List all offer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all offer"),
            @ApiResponse(code = 403, message = "Access to the offer you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The offer you were trying to reach is not found")
    })
    @GetMapping("/getAllOffers")
    public ResponseEntity<OfferOutboundPayload> getAllOffers() {
        return new ResponseEntity<>((OfferOutboundPayload) null, HttpStatus.OK);
    }



}
