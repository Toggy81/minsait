package com.minsait.demo.mapper;

import com.minsait.demo.entity.BrandEntity;
import com.minsait.demo.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toModel(BrandEntity brandEntity);
}
