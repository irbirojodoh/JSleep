package com.RijalJSleepFN;

import com.RijalJSleepFN.dbjson.Serializable;

import java.util.*;
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
    /** */
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

    // @Override
    public boolean read(String xxx){
        return true;
    }

    //@Override
    public Object write(){
        return null;
    }

    
}
