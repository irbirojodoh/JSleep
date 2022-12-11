package com.RijalJSleepFN.controller;

import com.RijalJSleepFN.*;
import com.RijalJSleepFN.dbjson.JsonAutowired;
import com.RijalJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



/**
 VoucherController is a RestController that handles requests and responses for Voucher resources. It implements the
 {@link BasicGetController} interface and provides methods for creating and modifying Payment objects.
 @see Voucher
 @see BasicGetController
 @author Ibrahim Rijal
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Room.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;


    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    /**
     * Method to make the set the voucher based on given id usage as used.
     * @param id
     * @return
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }

    /**
     * Method to check if the voucher is usable or not.
     * @param id
     * @param price
     * @return
     */
    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id, @RequestParam double price){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(),pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }

    /**
     * Method to get the available vouchers as a list
     * @param page
     * @param pageSize
     * @return
     */
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
