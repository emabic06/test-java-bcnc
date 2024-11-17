package com.bcnc.pricingapi.service;

import com.bcnc.pricingapi.dto.PriceResponseDTO;
import com.bcnc.pricingapi.entity.PriceEntity;
import com.bcnc.pricingapi.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
public class PriceServiceImpl implements PriceService  {

    @Autowired
    PriceRepository priceRepository;

    public PriceResponseDTO getApplicablePrice(int productId, Long brandId, LocalDateTime applicationDate ) {
        PriceResponseDTO dtoEmpty = new PriceResponseDTO();

        //Lógica de negocio
        return priceRepository.findByProductIdAndBrandIdAndApplicationDate(productId, brandId, applicationDate ).stream()
                .max(Comparator.comparing(PriceEntity::getPriority))
                .map(p -> new PriceResponseDTO(p.getProductId(),p.getBrandId(), p.getPriceList(),
                        p.getStartDate(),  p.getEndDate(), p.getPrice()))
                .orElse(dtoEmpty);
    }
}


