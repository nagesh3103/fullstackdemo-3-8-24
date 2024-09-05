package com.neoteric.fullstackdemo_38._4.controller;
import com.neoteric.fullstackdemo_38._4.exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_38._4.model.Account;
import com.neoteric.fullstackdemo_38._4.model.Atm;
import com.neoteric.fullstackdemo_38._4.service.AccountService;
import com.neoteric.fullstackdemo_38._4.service.AtmService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
    @RestController
    @CrossOrigin("*")
    public class AtmController {

        @PostMapping(value = "/createAtm",
                produces = "application/json",
                consumes = "application/json")
        public Atm createAtm(@RequestBody Account account){
            Atm atm=null;
            AtmService atmService=new AtmService();
            try {
                atm= atmService.createAtm(account);
            } catch (Exception e) {
                System.out.println("Exception Occured " +e);
            }
            return atm;
        }
    }

