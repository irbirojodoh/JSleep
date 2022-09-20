package RijalJSleepFN;

public class Price {
    
    double price;
    double rebate;
    int discount;

    public Price (double price){
        this.price = price;
    }

    public Price(double price, int discount){
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }

    public Price(double price, double rebate){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
        
    }

    private double getDiscountedPrice(){
        if(this.discount > 100){
            this.discount = 100;
        }else if(this.discount == 100){
            return 0;
        }else{
            return price - (price * discount / 100);
        }
        return 0;
        
    }

    private double getRebatedPrice(){
        if(this.rebate > this.price){
            this.rebate = this.price;
        }else{
            return this.price - rebate;
        }
        return 0;
    }
}
