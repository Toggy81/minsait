package com.minsait.demo.service.impl;

import com.minsait.demo.dto.PriceResponse;
import com.minsait.demo.exception.PriceException;
import com.minsait.demo.mapper.PriceMapper;
import com.minsait.demo.model.Price;
import com.minsait.demo.repository.PriceRepository;
import com.minsait.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public ResponseEntity<PriceResponse> getBy(LocalDateTime date, Integer productId, Integer brandId) throws PriceException {
        List<Price> prices = priceRepository.getPrices(date, productId, brandId)
                .stream()
                .map(priceMapper::toModel)
                .collect(toList());

        return getThePriceWithHighestPriority(prices);
    }

    private static ResponseEntity<PriceResponse> getThePriceWithHighestPriority(List<Price> prices) throws PriceException {
        Price price = prices.stream().max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(PriceException::new);
        return ResponseEntity.ok().body(new PriceResponse(price));
    }

}
