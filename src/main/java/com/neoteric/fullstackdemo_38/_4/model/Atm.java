package com.neoteric.fullstackdemo_38._4.model;

import lombok.Builder;

import java.util.Date;

@Builder
public class Atm {
    private String cardNumber;
    private String pin;
    private String accountNumber;
    private String cvv;
    private Date cardExpiry;
}
