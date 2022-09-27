package RijalJSleepFN;

public class Invoice extends Serializable {
    
    public int buyerId;
    public int renterId;
    public String time;

    protected Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
        //masi blum yakin
    }
    public String print(){
        return "Var buyerID, renterID, time: " + buyerId + ", " + renterId + ", " + time;
    }
}
