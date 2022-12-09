package com.RijalJSleepFN.controller;

import com.RijalJSleepFN.Account;
import com.RijalJSleepFN.Algorithm;
import com.RijalJSleepFN.Payment;
import com.RijalJSleepFN.Renter;
import com.RijalJSleepFN.dbjson.JsonAutowired;
import com.RijalJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.*;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    public static final String REGEX_EMAIL = "^[a-zA_Z0-9]+@[a-zA-Z.]+.[a-zA-Z.]+[a-zA-Z]$";
    public static final Pattern REGEX_PASSWORD_PATTERN = Pattern.compile(REGEX_PASSWORD);
    public static final Pattern REGEX_EMAIL_PATTERN = Pattern.compile(REGEX_EMAIL);

    @JsonAutowired(value = Account.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/account.json") public static JsonTable<Account> accountTable;
    public JsonTable<Account> getJsonTable(){



        return accountTable;
    }
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register (@RequestParam String name, @RequestParam String email, @RequestParam String password)
    {
        Matcher matcherEmail = REGEX_EMAIL_PATTERN.matcher(email);
        boolean matchEmail = matcherEmail.find();
        Matcher matcherPassword = REGEX_PASSWORD_PATTERN.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        if ( matchEmail && matchFoundPassword && !name.isBlank() && findAccount == null){
            try {

                // Static getInstance method is called with hashing MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // digest() method is called to calculate message digest
                // of an input digest() return array of byte
                byte[] messageDigest = md.digest(password.getBytes());

                // Convert byte array into signum representation
                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                Account account = new Account(name, email, hashtext);
                accountTable.add(account);
                return account;
            }

            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return null;

    }

    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            String finalHashtext = hashtext;
            Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email) && pred.password.equals(finalHashtext));
           // Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

            //final String generatedPassword = hashPassword(password);

            if (findAccount != null && finalHashtext.equals(findAccount.password)){
                return findAccount;
            }else{
                return null;
            }
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("{id}/registerRenter")
    public Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address, @RequestParam String phoneNumber){
        for(Account account : accountTable){
            if(account.id == id){
                Renter renter = new Renter(username, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        }
        return null;
    }

    @PostMapping("/{id}/topup")
    boolean topUp(@PathVariable int id, @RequestParam double amount)
    {
        Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);
        if (account != null){
            account.balance += amount;
            return true;
        }
        return false;
    }

    //@GetMapping("/{id}")
    //String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}
