package RijalJSleepFN;




public class Voucher extends Serializable {
    

    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(int id, String name, int code, Type type, double minimum, double cut) {
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }
    public boolean canApply(Price price){
        if (price.price > this.minimum && this.used == false){
            return true;
        }
        return false;
    }

    public double apply(Price price){
        
        this.used = true;
        if(this.type ==  Type.DISCOUNT){
            if(this.cut > 100){
                this.cut = 100;
            }
            return price.price - (price.price * this.cut / 100);
        }
        if(this.cut > price.price){
            this.cut = price.price;
        }
        return price.price - this.cut;
        
        
    }

    public boolean isUsed(){
        return used;
    }
} 
    

