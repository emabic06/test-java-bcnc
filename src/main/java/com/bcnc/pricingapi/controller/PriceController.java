package com.bcnc.pricingapi.controller;

import com.bcnc.pricingapi.exceptions.DataNotFoundException;
import com.bcnc.pricingapi.service.PriceService;
import com.bcnc.pricingapi.dto.PriceResponseDTO;
import com.bcnc.pricingapi.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<PriceResponseDTO> getPrice(@RequestParam int productId, @RequestParam Long brandId,
                                                     @RequestParam String applicationDate) {
        LocalDateTime date = LocalDateTime.parse(applicationDate);
        PriceResponseDTO results = priceService.getApplicablePrice(productId, brandId, date);

        boolean allFieldsNull = ObjectUtils.areAllFieldsNull(results);

        if (allFieldsNull)
        {
            throw new DataNotFoundException(HttpStatus.NOT_FOUND,"DatabaseNotFound",
                    "Datos no encontrados para la fecha indicada" );
        }
        return ResponseEntity.ok(results);
    }

}

