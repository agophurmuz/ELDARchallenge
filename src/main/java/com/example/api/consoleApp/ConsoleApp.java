package com.example.api.consoleApp;

import com.example.api.application.RateService;
import com.example.api.domain.Brand;
import com.example.api.domain.CreditCard;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ConsoleApp {

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
            List<CreditCard> list = mapper.readValue(response.body().string(), new TypeReference<List<CreditCard>>() {
            });

            System.out.println("Card info: " + list.get(0).getCardInfo());

            System.out.println("Card 2 valid to operate: " + list.get(1).validCardToOperate());

            System.out.println("Valid operation with card 3: " + list.get(2).validOperation(804.7));
            //System.out.println("Valid operation with card 3: " + list.get(3).validOperation(1804.7));

            System.out.println("Card 1 equals Card 2: " + list.get(0).equals(list.get(1)));
            System.out.println("Card 1 equals Card 1: " + list.get(0).equals(list.get(0)));

            RateService rateService = new RateService();

            System.out.println(rateService.rateSolver(Brand.VISA, 100.0));
            System.out.println(rateService.rateSolver(Brand.NARA, 100.0));
            System.out.println(rateService.rateSolver(Brand.AMEX, 100.0));

        }
    }
}

  