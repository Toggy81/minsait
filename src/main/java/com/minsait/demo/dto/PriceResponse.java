package com.minsait.demo.dto;

import com.minsait.demo.model.Price;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class PriceResponse {
    private Integer productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private Double price;

    public PriceResponse(Price price) {
        this.productId = price.getProductId();
        this.brandId = price.getBrand().getId();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.priority = price.getPriority();
        this.price = price.getPrice();
    }
}
