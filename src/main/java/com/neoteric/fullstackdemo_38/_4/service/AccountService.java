package com.neoteric.fullstackdemo_38._4.service;

import com.neoteric.fullstackdemo_38._4.exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_38._4.hibernate.HibernateUtils;
import com.neoteric.fullstackdemo_38._4.model.Account;
import com.neoteric.fullstackdemo_38._4.model.AccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class AccountService {
    public String createAccountUsingHibernate(Account account){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(UUID.randomUUID().toString());
        accountEntity.setName(account.getName());
        accountEntity.setPan(account.getPan());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setMobileNumber(account.getMobileNumber());
        session.persist(accountEntity);
        return "";
    }
    public String createAccount(Account account) throws AccountCreationFailedException {
        String accountNumber=null;
        try{
            Connection connection = DBConnection.getConnection();
            Statement stmt = connection.createStatement();
             accountNumber = UUID.randomUUID().toString();
//            insert into bank.account values('123456','chandra','52364','9898562315',20000.0);
            String query = "insert into bank.account values('"+
                    accountNumber+"'"+","+

                    "'"+account.getName()+"'"+","+
                    "'"+account.getPan()+"'"+","+
                    "'"+account.getMobileNumber()+"'"+","
                    + account.getBalance()+")";
            int status = stmt.executeUpdate(query);

            if (status==1){
                System.out.println("Account is created "+accountNumber);
            }else{
                throw new AccountCreationFailedException("Account creation is failed"+account.getPan());
            }

        }catch ( SQLException e){
            System.out.println("Exception occurred in sql"+e);

        }catch (AccountCreationFailedException e){
            System.out.println("Exception occurred"+e);
            throw e;
        }
        return accountNumber;
    }
}
