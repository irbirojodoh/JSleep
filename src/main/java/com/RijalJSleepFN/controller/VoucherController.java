package com.RijalJSleepFN.controller;

import com.RijalJSleepFN.Algorithm;
import com.RijalJSleepFN.Price;
import com.RijalJSleepFN.Room;
import com.RijalJSleepFN.Voucher;
import com.RijalJSleepFN.dbjson.JsonAutowired;
import com.RijalJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Room.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;


    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id, @RequestParam double price){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(),pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(@RequestParam int page, @RequestParam int pageSize){
        List<Voucher> list1 = new ArrayList<Voucher>();
        for (Voucher i : getJsonTable()){
            if(!i.isUsed()){
                list1.add(i);
            }
        }
        return Algorithm.<Voucher>paginate(list1,page,pageSize, pred -> true);
    }

}
