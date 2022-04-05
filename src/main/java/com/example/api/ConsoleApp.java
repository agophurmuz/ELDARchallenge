package com.example.api;

import com.example.api.application.RateService;
import com.example.api.domain.Brand;
import com.example.api.domain.CardHolder;
import com.example.api.domain.CreditCard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ConsoleApp {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(String[] args) {


        CreditCard cc1 = new CreditCard(Brand.VISA, "1", new CardHolder("Luis", "Martinez"), LocalDate.of(2023, 5, 5));
        CreditCard cc2 = new CreditCard(Brand.NARA, "2", new CardHolder("Diego", "Lopez"), LocalDate.of(2024, 6, 6));
        CreditCard cc3 = new CreditCard(Brand.AMEX, "3", new CardHolder("Jose", "Perez"), LocalDate.of(2025, 7, 7));

        System.out.println("Card info: " + cc1.getCardInfo());

        System.out.println("Card 2 valid to operate: " + cc2.validCardToOperate());

        System.out.println("Valid operation with card 3: " + cc3.validOperation(804.7));
        System.out.println("Valid operation with card 3: " + cc3.validOperation(1804.7));

        System.out.println("Card 1 equals Card 2: " + cc1.equals(cc2));
        System.out.println("Card 1 equals Card 1: " + cc1.equals(cc1));

        RateService rateService = new RateService();

        System.out.println(rateService.rateSolver(Brand.VISA, 100.0));
        System.out.println(rateService.rateSolver(Brand.NARA, 100.0));
        System.out.println(rateService.rateSolver(Brand.AMEX, 100.0));
    }
}

  