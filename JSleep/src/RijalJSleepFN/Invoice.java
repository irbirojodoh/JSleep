package RijalJSleepFN;

import java.util.*;

public class Invoice extends Serializable {
    
    public int buyerId;
    public int renterId;
    public Date time;
    public RoomRating rating;
    public PaymentStatus status;

    public enum RoomRating{
        NONE,BAD,NEUTRAL,GOOD
    }
    public enum PaymentStatus{
        FAILED,WAITING,SUCCESS
    }
    /** */
    protected Invoice(int id, int buyerId, int renterId){
        //super(id);
        Date time = new Date();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    public Invoice(int id, Account buyer, Renter renter){
        //super(id);
        Date time = new Date();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    public String print(){
        return "Var buyerID, renterID, time: " + buyerId + ", " + renterId + ", " + time;
    }
}
