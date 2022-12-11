package com.RijalJSleepFN;

import com.RijalJSleepFN.dbjson.Serializable;

import java.util.*;

/**
 This class represents a room that is available for booking.
 @author Ibrahim Rijal
 */
public class Room extends Serializable {
    public int size;
    public String name;
    public String address;
    public ArrayList<Facility> facility = new ArrayList<>();
    public Price price;
    public BedType bedType;
    public City city;

    public int accountId;
    public ArrayList<Date> booked = new ArrayList<>();
    /**
     Constructs a new Room object with the specified parameters.
     @param accountId The ID of the account that owns the room
     @param name The name of the room
     @param size The size of the room in square feet
     @param price The price of the room
     @param facility The list of facilities available in the room
     @param city The city where the room is located
     @param address The address of the room
     @param bedType The type of bed in the room
     */
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType) {
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.city = city;
        this.address = address;
        this.bedType = bedType;
        this.facility.addAll(facility);

        this.booked = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Room{" +
                "size=" + size +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", facility=" + facility +
                ", price=" + price +
                ", bedType=" + bedType +
                ", city=" + city +
                ", accountId=" + accountId +
                ", booked=" + booked +
                '}';
    }

    /**
     *
     * @param xxx
     * @return
     * @deprecated
     */
    public boolean read(String xxx){
        return true;
    }

    /**

     * @return
     * @deprecated
     */
    public Object write(){
        return null;
    }

    
}
