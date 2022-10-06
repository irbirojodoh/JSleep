package RijalJSleepFN;

import java.util.Calendar;
import java.util.Date;
import java.text.*;

public class Payment extends Invoice {
    public Date to;
    public Date from;
    private int roomId;
    
    /** constructor untuk melakukan pengisian thd var instance */
    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to){
        super(id, buyerId, renterId);
        //Calendar time = Calendar.getInstance();
        this.from = new Date();
        this.to = new Date();
        //this.to.add(Calendar.DATE, 2);
        
        this.roomId = roomId;
    }

    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to){
        super(id, buyer.id, renter.id);
        this.from = from;
        this.to = to;
        //this.to.add(Calendar.DATE, 2);
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

    // public String getDuration(){
    //     SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
    //     return sdf.format(this.from.getTime())+" - "+sdf.format(this.to.getTime());
    
    // }
    public static boolean availability(Date from,Date to, Room room){
        if (room.booked.size() == 0){
            return true;
        }
        
        
        for (Date date : room.booked) {
            if (date.equals(from) || date.equals(to)) {
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from,Date to,Room room){
        if(from.after(to)){
            return false;
        }
        
        if (availability(from, to, room)) {
            for (Date date = from; date.before(to);) {
                room.booked.add(date);
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
                
               
            }
            return true;
        }
        return false;
    }

}
