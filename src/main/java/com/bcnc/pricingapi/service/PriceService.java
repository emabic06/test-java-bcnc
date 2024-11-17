package com.bcnc.pricingapi.service;

import com.bcnc.pricingapi.dto.PriceResponseDTO;

import java.time.LocalDateTime;

public interface PriceService {

    PriceResponseDTO getApplicablePrice(int productId, Long brandId, LocalDateTime applicationDate );
}
