package RijalJSleepFN;

public class Payment extends Invoice {
    public String to;
    public String from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to){
        super(id, buyerId, renterId, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to){
        super(id, buyer.id, renter.id, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public String print(){
        return "Var to, from, roomId: "+ to + ", "+ from+ ", "+ roomId;
    }
    public int getRoomId(){
        return roomId;
    }
}
