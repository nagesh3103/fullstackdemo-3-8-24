package com.neoteric.fullstackdemo_38._4.exception;

public class AccountCreationFailedException extends Exception{
    public String message;

    public AccountCreationFailedException(String ms){
        this.message =ms;
    }

}
