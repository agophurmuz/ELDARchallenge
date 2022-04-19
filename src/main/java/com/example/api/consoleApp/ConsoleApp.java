package com.example.api.consoleApp;

import com.example.api.application.RateService;
import com.example.api.domain.Brand;
import com.example.api.domain.CardHolder;
import com.example.api.domain.CreditCard;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ConsoleApp {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");



    public static void main(String[] args) throws Exception{

        final OkHttpClient httpClient = new OkHttpClient();


        Request request = new Request.Builder()
                .url("https://secure-gorge-97594.herokuapp.com/creditCard/")
                .addHeader("User-Agent", "PostmanRuntime/7.26.8")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }


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

  