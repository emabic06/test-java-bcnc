package com.bcnc.pricingapi.service;

import com.bcnc.pricingapi.entity.PriceEntity;
import com.bcnc.pricingapi.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public List<PriceEntity> getApplicablePrice(int productId, Long brandId, LocalDateTime applicationDate ) {
        return priceRepository.findByProductIdAndBrandIdAndApplicationDate(productId, brandId, applicationDate );
    }
}


