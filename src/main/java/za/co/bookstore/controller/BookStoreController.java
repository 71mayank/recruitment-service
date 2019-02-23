package za.co.bookstore.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bookstore.dto.BookDTO;
import za.co.bookstore.response.BookResponse;
import za.co.bookstore.service.BookServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("bookstore")
@Api(value = "Book Service ", description = "Operations related to book store")
public class BookStoreController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @ApiOperation(value = "View latest currency rates", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved latest exchange rate for BTC"),
            @ApiResponse(code = 401, message = "You are not authorized to view the currency exchange rates"),
            @ApiResponse(code = 403, message = "Access to the currency exchange you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The currency exchange rate you were trying to reach is not found")
    })
    @PostMapping(value = "/saveBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> getLatestRates(@RequestBody BookDTO bookDTO) {
        return bookServiceImpl.saveBook(bookDTO);
    }

    @ApiOperation(value = "View historical currency exchange rates for specified start and end Date", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved historical exchange rate for BTC"),
            @ApiResponse(code = 401, message = "You are not authorized to view the currency exchange rates"),
            @ApiResponse(code = 403, message = "Access to the currency exchange you were trying is forbidden"),
            @ApiResponse(code = 404, message = "The currency exchange rate you were trying to reach is not found")
    })
    @GetMapping("/getAllBooks")
    public ResponseEntity<BookResponse> getAllBooks(@ApiParam(value = "LocalDateTime Format YYYY-MM-DDTHH:MM:SS", required = true) @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                    @ApiParam(value = "LocalDateTime Format YYYY-MM-DDTHH:MM:SS", required = true) @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return new ResponseEntity<>((BookResponse) null, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookById")
    public ResponseEntity<BookResponse> deleteBookById(@ApiParam(value = "LocalDateTime Format YYYY-MM-DDTHH:MM:SS", required = true) @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                       @ApiParam(value = "LocalDateTime Format YYYY-MM-DDTHH:MM:SS", required = true) @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return new ResponseEntity<>((BookResponse) null, HttpStatus.OK);
    }

    @PutMapping("/updateBookById")
    public ResponseEntity<BookResponse> updateBookById(@ApiParam(value = "LocalDateTime Format YYYY-MM-DDTHH:MM:SS", required = true) @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                       @ApiParam(value = "LocalDateTime Format YYYY-MM-DDTHH:MM:SS", required = true) @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return new ResponseEntity<>((BookResponse) null, HttpStatus.OK);
    }
}
