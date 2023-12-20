package com.minsait.demo.repository;

import com.minsait.demo.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query("SELECT e FROM PriceEntity e WHERE :date BETWEEN e.startDate AND e.endDate AND :productId=e.productId AND :brandId=e.brand.id")
    List<PriceEntity> getPrices(LocalDateTime date, Integer productId, Integer brandId);
}
