package com.RijalJSleepFN.controller;

import com.RijalJSleepFN.*;
import com.RijalJSleepFN.dbjson.JsonAutowired;
import com.RijalJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.*;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Room.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/room.json")
    public static JsonTable<Room> roomTable;

    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(@PathVariable int id, @PathVariable int page, @PathVariable int pageSize){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }
    @PostMapping("/create")
    public Room create(@RequestParam int accountId,@RequestParam String name,@RequestParam int size, @RequestParam int price, @RequestParam ArrayList<Facility> facility, @RequestParam City city, @RequestParam String address, @RequestParam BedType bedType){
        Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if (acc != null) {
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            roomTable.add(room);
            return room;
        }else
            return null;
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize

    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
