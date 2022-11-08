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
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired
            (value = Payment.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/payment.json") public static JsonTable<Payment> paymentTable;
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create(@RequestParam int buyerId,@RequestParam int  renterId,@RequestParam int  roomId,@RequestParam  String from,@RequestParam  String to){
        return null;
    }

    public Payment accept(@RequestParam int id){
        return null;
    }
    public Payment cancel(@RequestParam int id){
        return null;
    }
    public Payment submit(@RequestParam int id){
        return null;
    }
}

