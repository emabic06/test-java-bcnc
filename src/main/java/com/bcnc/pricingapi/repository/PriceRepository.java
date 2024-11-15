package com.bcnc.pricingapi.repository;
import com.bcnc.pricingapi.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

    @Repository
    public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

        @Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId AND p.startDate <= :date AND p.endDate >= :date")
        List<PriceEntity> findByProductIdAndBrandIdAndApplicationDate(
                @Param("productId") int productId,
                @Param("brandId") Long brandId,
                @Param("date") LocalDateTime date);

    }

