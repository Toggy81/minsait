package com.minsait.demo.controller;

import com.minsait.demo.dto.PriceResponse;
import com.minsait.demo.exception.ErrorMessage;
import com.minsait.demo.exception.PriceException;
import com.minsait.demo.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {
    @Autowired
    private PriceService priceService;

    @Operation(summary = "Get priority price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the price",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PriceResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "Price not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorMessage.class))) })

    @GetMapping(value="/prices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponse> getAllPrices(@RequestParam LocalDateTime date, @RequestParam Integer productId, @RequestParam Integer brandId ) throws PriceException {
        return priceService.getBy(date, productId, brandId);
    }
}
