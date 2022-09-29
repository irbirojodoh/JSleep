package RijalJSleepFN;

public class Room extends Serializable {
    public int size;
    public String name;
    public String address;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;


    /** */
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address){
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }

    public String toString() {
        return "address=" + address + ", bedType=" + bedType + ", city=" + city + ", facility=" + facility
                + ", name=" + name + ", price=" + price + ", size=" + size ;
    }


    
}
