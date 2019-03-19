package za.co.recruitment.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.recruitment.inbound.OfferInboundPayload;
import za.co.recruitment.outbound.OfferOutboundPayload;
import za.co.recruitment.service.impl.OfferServiceImpl;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("offer")
@Api(value = "Offer Service ", description = "Operations related to job offer")
public class OfferController {

    @Autowired
    OfferServiceImpl offerServiceImpl;

    @ApiOperation(value = "Add an offer", response = OfferOutboundPayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added job offer"),
            @ApiResponse(code = 409, message = "Conflict JobTitle already exists")
    })
    @PostMapping(value = "/createJobOffer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OfferOutboundPayload> createJobOffer(@Valid @RequestBody OfferInboundPayload offerInboundPayload) {
        return offerServiceImpl.saveOffer(offerInboundPayload);
    }

    @ApiOperation(value = "Read single offer", response = OfferOutboundPayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved offer"),
            @ApiResponse(code = 400, message = "Bad Request")

    })
    @GetMapping("/getOfferById")
    public ResponseEntity<OfferOutboundPayload> getOfferById(@ApiParam(value = "offerId", required = true)
                                                             @RequestParam(value = "offerId") Long offerId) {
        return offerServiceImpl.getOfferById(offerId);
    }

    @ApiOperation(value = "List all offers", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all offer"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/getAllOffers")
    public ResponseEntity<List<OfferOutboundPayload>> getAllOffers() {
        return offerServiceImpl.getOffers();
    }

}
