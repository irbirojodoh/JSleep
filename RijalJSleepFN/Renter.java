package RijalJSleepFN;

public class Renter extends Serializable {
    
    public int phoneNumber = 0;
    public String username;
    public String address;
   
   
    public Renter(int id, String username){
        super(id);
        this.id = id;
        this.username = username;
    }

    public Renter(int id, String username, String address){
        super(id);
        this.id = id;
        this.username = username;
        this.address = address;
    }
    public Renter(int id, String username, int phoneNumber){
        super(id);
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public Renter(int id, String username, int phoneNumber, String address){
        super(id);
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
