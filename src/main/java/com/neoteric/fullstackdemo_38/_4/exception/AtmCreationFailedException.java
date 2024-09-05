package com.neoteric.fullstackdemo_38._4.exception;

public class AtmCreationFailedException extends Exception {
    public String message;

    public AtmCreationFailedException( String message){

        this.message=message;

    }

}
