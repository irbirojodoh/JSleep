package com.RijalJSleepFN.controller;

import com.RijalJSleepFN.Account;
import com.RijalJSleepFN.Algorithm;
import com.RijalJSleepFN.Payment;
import com.RijalJSleepFN.Renter;
import com.RijalJSleepFN.dbjson.JsonAutowired;
import com.RijalJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @JsonAutowired
   (value = Account.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/account.json") public static JsonTable<Account> accountTable;
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

            return new Account(name, email, password);
        }
        return null;

    }

    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password)
    {
        return Algorithm.<Account>find(accountTable, pred -> pred.email.equals(email) && pred.password.equals(password));
    }

    @PostMapping("/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String name, @RequestParam String email, @RequestParam String password)
    {
        Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);

        if (account != null){
            account.renter = new Renter(name, email, password);
        }
        return null;
    }

    @PostMapping("/{id}/topup")
    boolean topUp(@PathVariable int id, @RequestParam int amount)
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
