package com.minsait.demo.mapper;

import com.minsait.demo.entity.PriceEntity;
import com.minsait.demo.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    Price toModel(PriceEntity priceEntity);
}
