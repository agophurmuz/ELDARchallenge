package com.example.api.domain;

import com.example.api.application.RateDTO;

import java.time.LocalDate;

public enum Brand implements RateStrategy {
    VISA {
        @Override
        public double getResult(double amount, LocalDate today) {
            return  ((double)(today.getYear()-2000))/(today.getMonthValue())*amount;
        }
    }, NARA {
        @Override
        public double getResult(double amount, LocalDate today) {
            return (today.getDayOfMonth()*0.5)*amount;

        }
    }, AMEX {
        @Override
        public double getResult(double amount, LocalDate today) {
            return  (today.getMonthValue()*0.1)*amount;
        }
    };

    @Override
    public RateDTO rateOperation(double amount) {
        LocalDate today = LocalDate.now();
        double result = getResult(amount, today);
        return new RateDTO(this, result);
    }

    public abstract double getResult(double amount, LocalDate today);
}
