package RijalJSleepFN;

import java.util.Calendar;
import java.util.Date;
import java.text.*;

public class Payment extends Invoice {
    public Calendar to;
    public Calendar from;
    private int roomId;
    
    /** constructor untuk melakukan pengisian thd var instance */
    public Payment(int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        //Calendar time = Calendar.getInstance();
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        
        this.roomId = roomId;
    }

    public Payment(int id, Account buyer, Renter renter, int roomId){
        super(id, buyer.id, renter.id);
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }

    public String print(){
        return "Var to, from, roomId: "+ to + ", "+ from+ ", "+ roomId;
    }
    public int getRoomId(){
        return roomId;
    }

    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(this.time.getTime());
    }

    public String getDuration(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(this.from.getTime())+" - "+sdf.format(this.to.getTime());
     
    }
}
