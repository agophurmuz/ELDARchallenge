package com.example.api.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    private RateService rateService;

    @GetMapping("/")
    public ResponseEntity<RateDTO> getRate(@RequestBody RateDTO rateBody){
        return ResponseEntity.ok(rateService.rateSolver(rateBody.getBrand(), rateBody.getAmount()));
    }
}
