package com.example.api.application;

import com.example.api.domain.Brand;

public class RateDTO {

    private Brand brand;
    private double amount;

    public RateDTO() {
    }

    public RateDTO(Brand brand, double imp) {
        this.brand = brand;
        this.amount = imp;
    }

    public Brand getBrand() {
        return brand;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "brand= " + brand.toString() + ", amount= " + amount;
    }
}
