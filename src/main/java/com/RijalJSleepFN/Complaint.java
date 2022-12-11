package com.RijalJSleepFN;

import com.RijalJSleepFN.dbjson.Serializable;


/**
 The Complaint class represents a complaint made by a user.
 @author Ibrahim Rijal
 */
public class Complaint extends Serializable {
    
    public String desc;
    public String date;



    /**
     Constructs a new Complaint instance with the given id, date, and description.
     @param id The id of the complaint.
     @param date The date when the complaint was made.
     @param desc The description of the complaint.
     */
    public Complaint(int id, String date, String desc) {
      //  super(id);
        this.desc = desc;
        this.date = date;
    }

    /**
     Returns a string representation of the Complaint object.
     @return A string in the format "Desc: {description} Date: {date}"
     */
    public String toString(){
        return "Desc: " + desc + " Date: " + date;
    }

    
    
}
