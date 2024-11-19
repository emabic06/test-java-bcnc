package com.bcnc.pricingapi.infrastructure.database;

import com.bcnc.pricingapi.entity.PriceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bcnc.pricingapi.repository.PriceRepository;
import org.springframework.boot.ApplicationRunner ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    ApplicationRunner initDatabase(PriceRepository repository) {
        return args -> {

            for (PriceEntity entity : List.of(
                    new PriceEntity(1L, LocalDateTime.of(2020, 6, 14, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.50, "EUR" ),
                    new PriceEntity(1L, LocalDateTime.of(2020, 6, 14, 15, 0), LocalDateTime.of(2020, 6, 14, 18, 30), 2, 35455, 1, 25.45, "EUR"),
                    new PriceEntity(1L, LocalDateTime.of(2020, 6, 15, 0, 0), LocalDateTime.of(2020, 6, 15, 11, 0), 3, 35455, 1, 30.50, "EUR"),
                    new PriceEntity(1L, LocalDateTime.of(2020, 6, 15, 16, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 4, 35455, 1, 38.95, "EUR")
            )) {
                repository.save(entity);
            }
        };
    }
}
