package com.RijalJSleepFN;

import java.util.*;
public class Room extends Serializable   {
    public int size;
    public String name;
    public String address;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;

    public int accountId;
    public ArrayList<Date> booked;
    /** */
    public Room(int accountId, String name, int size, Price price, Facility facility, City city, String address) {
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<>();
    }

    public String toString() {
        return "id = " + this.id + "address=" + this.address + ", bedType=" + this.bedType + ", city=" + this.city + ", facility=" + this.facility
                + ", name=" + this.name + ", price=" + this.price + ", size=" + this.size ;
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
