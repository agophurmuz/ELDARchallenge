package com.example.api.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CreditCard {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private int id;
    private Brand brand;
    private String cardNumber;
    private CardHolder cardHolder;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    public CreditCard() {
    }

    public CreditCard(final int id, final  Brand brand, final String cardNumber, final CardHolder cardHolder, final LocalDate expirationDate) {
        this.id = id;
        this.brand = brand;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
    }

    public String getCardInfo() {
        return "Brand: " + brand + ", Card Number: " + cardNumber + " " + cardHolder.toString() +
                ", Expiration Date: " + dateFormat.format(expirationDate);
    }

    public boolean validOperation (final double cant) {
        if(validCardToOperate() && cant < 1000.0)
            return true;
        throw new IllegalArgumentException("Not valid amount to operate");
    }


    public boolean validCardToOperate() {
        if ((expirationDate.compareTo(LocalDate.now())) > 0)
            return true;
        throw new IllegalArgumentException("Not valid card to operate");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return brand == that.brand &&
                Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, cardNumber);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }


    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
