package com.RijalJSleepFN.controller;



import com.RijalJSleepFN.*;
import com.RijalJSleepFN.dbjson.JsonAutowired;
import com.RijalJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired
            (value = Payment.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create(@RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId, @RequestParam String from, @RequestParam String to) throws ParseException {
        Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId && pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId && pred.accountId == roomId);

       // Price price = new Price(room.price.price);
        double price = room.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if(acc.balance >= price && acc != null && room != null  ){
            Payment payment = new Payment(acc.id, buyerId, renterId, roomId, fromDate, toDate);
            acc.balance -= price;
            payment.status=Invoice.PaymentStatus.WAITING;
            payment.makeBooking(fromDate, toDate, room);
            paymentTable.add(payment);
            return payment;
        }
        return null;
    }
    @PostMapping("/{id}/accept")
    public boolean accept(@RequestParam int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }
    @PostMapping("/{id}/cancel")
    public boolean cancel(@RequestParam int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.FAILED;
            Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            acc.balance += room.price.price;
            return true;
        }
        return false;
    }
}


