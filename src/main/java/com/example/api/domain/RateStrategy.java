package com.example.api.domain;

import com.example.api.application.RateDTO;

public interface RateStrategy {

    RateDTO rateOperation(double amount);
}
