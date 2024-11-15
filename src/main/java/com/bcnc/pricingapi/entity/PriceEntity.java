package com.bcnc.pricingapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity
    public class PriceEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private int priceList;
        private int productId;
        private int priority;
        private double price;
        private String currency;

        //Constructor por defecto necesario para que JPA pueda instanciar la entidad correctamente
        public PriceEntity() {
        }

        public PriceEntity( Long brandId, LocalDateTime startDate, LocalDateTime endDate, int priceList, int productId, int priority, double price, String currency) {
            this.brandId = brandId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.priceList = priceList;
            this.productId = productId;
            this.priority = priority;
            this.price = price;
            this.currency = currency;
        }

        public Long getBrandId() {
            return brandId;
        }

        public void setBrandId(Long brandId) {
            this.brandId = brandId;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
        }

        public LocalDateTime getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
        }

        public int getPriceList() {
            return priceList;
        }

        public void setPriceList(int priceList) {
            this.priceList = priceList;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }


