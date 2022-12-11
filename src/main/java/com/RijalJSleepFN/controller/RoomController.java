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


/**
 RoomController is a RestController that handles requests and responses for Room resources. It implements the
 {@link BasicGetController} interface and provides methods for creating and modifying Payment objects.
 @see Room
 @see BasicGetController
 @author Ibrahim Rijal
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired (value = Room.class, filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/src/json/room.json")

    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }
    @GetMapping
    String index() { return "duhuwdw"; }


    /**

     This method returns a list of rooms rented by the renter with the given id.
     @param id the id of the renter to search for
     @param page the page number of the result list to return
     @param pageSize the number of results to return per page
     @return a list of rooms rented by the renter with the given id
     */
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }


    /**
     * Creates a new room with the given parameters and associates it with the specified account.
     *
     * @param accountId the ID of the account to associate the room with
     * @param name the name of the room
     * @param size the size of the room in square meters
     * @param price the price of the room per night
     * @param facility the list of facilities available in the room
     * @param city the city where the room is located
     * @param address the address of the room
     * @param bedType the type of bed in the room
     * @return the newly created room, or `null` if the specified account ID is invalid or the account is not registered as a renter
     */
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


    /**
     * Returns a list of all rooms in the system, paginated by page and page size.
     * @param page     The page number to return.
     * @param pageSize The number of items per page.
     * @return A list of rooms for the specified page and page size.
     */
    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize

    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
