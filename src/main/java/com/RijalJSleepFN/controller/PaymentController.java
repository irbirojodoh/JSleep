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
    public Payment create(
            @RequestParam int buyerId,@RequestParam int renterId,
            @RequestParam int roomId, @RequestParam String from, @RequestParam String to
    ){
        Account cari = Algorithm.<Account>find(AccountController.accountTable,pred->pred.id==buyerId);
        Room cariruang = Algorithm.<Room>find(RoomController.roomTable, pred->pred.id==roomId);
        double hargaKamar = cariruang.price.price;
        System.out.println(from);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromtgl=null;
        Date totgl=null;
        try{
            fromtgl = sdf.parse(from);
            totgl = sdf.parse(to);
            System.out.println("date  "+totgl);
            // if(cari.balance>=hargaKamar&&Payment.availability(fromtgl, totgl, cariruang)){
            //     Payment baru = new Payment(buyerId,renterId,roomId,fromtgl,totgl);
            //     baru.status=Invoice.PaymentStatus.WAITING;
            //     Payment.makeBooking(fromtgl, totgl, cariruang);
            //     System.out.println("response backend: "+baru.toString());
            //     paymentTable.add(baru);
            //     return baru;
            // }
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        long diffInMilliseconds = totgl.getTime() - fromtgl.getTime();
        long diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);

        System.out.println(cari.toString());
        if(cari.balance>=hargaKamar * diffInDays &&Payment.availability(fromtgl, totgl, cariruang)){
            System.out.println(cari.toString());
            Payment baru = new Payment(buyerId,renterId,roomId,fromtgl,totgl);
            baru.status=Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(fromtgl, totgl, cariruang);
            cari.balance-=hargaKamar * (double) diffInDays;
            //apa ngurangin jumlahnya disini?
            System.out.println("response backend: "+baru.toString());
            paymentTable.add(baru);
            return baru;
        }
        if(cari.balance<hargaKamar){
            System.out.println("gapunya duit ya");
        }
        if(!Payment.availability(fromtgl, totgl, cariruang)){
            System.out.println("kamar sudah di booking");
        }
        return null;
        //return new Payment(buyerId,renterId,roomId,fromtgl,totgl);

    }
    @PostMapping("/{id}/accept")
    public boolean accept(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }
    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        long diffInMilliseconds = payment.to.getTime() - payment.from.getTime();
        long diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.FAILED;
            Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            acc.balance += diffInDays * room.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/rating")
    public boolean rating(@PathVariable int id, @RequestParam String rating) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);

        if (payment != null && payment.status == Invoice.PaymentStatus.SUCCESS) {
            System.out.println("rating: "+rating);
            payment.rating = Invoice.RoomRating.valueOf(rating);
            return true;
        }
        return false;
    }

    @GetMapping("getAll/{id}")
    List<Payment> getAccountPayment(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.buyerId == id);
    }
}


