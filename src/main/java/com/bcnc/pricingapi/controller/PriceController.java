package com.bcnc.pricingapi.controller;

import com.bcnc.pricingapi.service.PriceService;
import com.bcnc.pricingapi.dto.PriceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping("/price")
    public PriceResponseDTO getPrice(@RequestParam int productId, @RequestParam Long brandId,
                                     @RequestParam String applicationDate) {
        LocalDateTime date = LocalDateTime.parse(applicationDate);

        return priceService.getApplicablePrice(productId, brandId, date);
    }

}

