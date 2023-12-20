package com.minsait.demo.service;

import com.minsait.demo.dto.PriceResponse;
import com.minsait.demo.exception.PriceException;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface PriceService {
    ResponseEntity<PriceResponse> getBy(LocalDateTime startDate, Integer productId, Integer brandId) throws PriceException;
}
