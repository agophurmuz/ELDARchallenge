package com.example.api.application;

import com.example.api.domain.Brand;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.Validate;

@Service
public class RateService {

    public RateService() {
    }

    public RateDTO rateSolver(final Brand brand, final double amount) {
        Validate.notNull(brand, "The brand cannot be null.");
        return brand.rateOperation(amount);
    }
}
