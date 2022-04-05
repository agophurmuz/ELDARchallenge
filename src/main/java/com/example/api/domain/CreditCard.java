package com.example.api.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CreditCard {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private Brand brand;
    private String cardNumber;
    private CardHolder cardHolder;
    private LocalDate expirationDate;

    public CreditCard(final  Brand brand, final String cardNumber, final CardHolder cardHolder, final LocalDate expirationDate) {
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
        return validCardToOperate() && cant < 1000.0;
    }

    public boolean validCardToOperate() {
        return (expirationDate.compareTo(LocalDate.now())) > 0;
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
}
