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
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date' = dd MMMM yyyy");
        String currTime = SDFormat.format(time.getTime());
        return currTime;
    }

    // public String getDuration(){
    //     SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
    //     return sdf.format(this.from.getTime())+" - "+sdf.format(this.to.getTime());
    
    // }
    public static boolean availability(Date from,Date to,Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }


    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

}
