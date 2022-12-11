package com.RijalJSleepFN;

import com.RijalJSleepFN.dbjson.Serializable;

/**
 * This class represents a renter, who can be associated with a username, phone number, and address.
 *
 * @author Ibrahim Rijal
 * @version 1.0
 */
public class Renter extends Serializable {
    
    public  String phoneNumber;
    public String username;
    public String address;

    // regex for username minimum 4 character maximum 20 character


    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
   
   
/*    public Renter(int id, String username){
        this.username = username;
    }
*/
    /**
     * Constructs a new `Renter` object with the given username, phone number, and address.
     *
     * @param username the renter's username
     * @param phoneNumber the renter's phone number
     * @param address the renter's address
     */
    public Renter(String username, String address, String phoneNumber){

        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    /*
    public Renter(int id, String username, String phoneNumber){
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public Renter(int id, String username, String phoneNumber, String address){

        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

     */

    /**
     * Validates the renter's username and phone number using the regular expressions {@code REGEX_NAME} and {@code REGEX_PHONE}.
     *
     * @return {@code true} if the username and phone number are valid, {@code false} otherwise
     */
    public boolean validate(){
        return this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE);
    }
}
