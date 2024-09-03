package com.neoteric.fullstackdemo_38._4.exception;

public class AccountCreationFailedException extends Exception{
    public String messae;

    public AccountCreationFailedException(String ms){
        this.messae=ms;
    }

}
