package RijalJSleepFN;

import java.util.*;


//MODUL 1 PERKENALAN
public class JSleep {


    // public static Room createRoom(){
    //     Price price= new Price(1000000, 5);
    //    // Room room = new Room("Deluxe", 2, price, Facility.AC);
    //     return room;
    // }
    /** Testing projec*/
    public static void main(String[] args){
        
        Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        
        for(int i=0;i < unfilteredArray.length;i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length;i++){
            System.out.println(unfilteredArray[i].price);
        }

        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));



        /*bekas kemaren 
        System.out.println("Warming up JSleep");
        Scanner input = new Scanner(System.in);
        System.out.println("========================TESTING METHOD============================");
        System.out.print("Masukan harga awal    : ");
        int hargaAwal = input.nextInt();
        System.out.print("Masukan harga akhir   : ");
        int hargaAkhir = input.nextInt();
        System.out.print("Masukan lama menginap : ");
        int nights = input.nextInt();

        System.out.println("==================================================================");
        System.out.println("Testing getHotelId              : " + getHotelId());
        System.out.println("Testing getHotelName            : " + getHotelName());
        System.out.println("Testing isDiscount              : " + isDiscount() );
        System.out.println("Testing getDiscountPercentage   : " + getDiscountPercentage(hargaAwal, hargaAkhir)+"%");
        System.out.println("Testing getDiscoutedPrice       : Rp" + getDiscountedPrice(hargaAwal, getDiscountPercentage(hargaAwal, hargaAkhir)));
        System.out.println("Testing getOriginalPrice        : Rp" + getOriginalPrice(getDiscountedPrice(hargaAwal, getDiscountPercentage(hargaAwal, hargaAkhir)), getDiscountPercentage(hargaAwal, hargaAkhir)));
        System.out.println("Testing getAdminFeePercentage   : " + getAdminFeePercentage()*100+"%");
        System.out.println("Testing getAdminFee             : Rp" + getAdminFee(hargaAwal));
        System.out.println("Testing getTotalPrice           : Rp" + getTotalPrice(hargaAwal, nights)); */
    }

    
   


    //Bekas kemaren
   /*  static int getHotelId(){
        return 0;
    }
    static String getHotelName(){
        return "hotel";
    }
    static boolean isDiscount(){
        return true;
    }
    static float getDiscountPercentage(int beforeDiscount, int afterDiscount) {
        if (beforeDiscount < afterDiscount)
            return 0;
        else
            return ((float)(beforeDiscount - afterDiscount) / (float)beforeDiscount) *100;
    }
    static int getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100)
            return 0;
        else
            return (int) (((float) price) - ((float)( price * discountPercentage / 100)));
        
    }
    static int getOriginalPrice(int discountedPrice, float discountPercentage){

        if (discountPercentage >= 100)
            return 0;
        else
            return (int)((discountedPrice ) / (1 - discountPercentage / 100));
    }
    static float getAdminFeePercentage(){
        return 0.05f;
    }
    static int getAdminFee(int price){
        return (int) (price * getAdminFeePercentage());
    }
    static int getTotalPrice(int price, int numberOfNight){
        return (price + getAdminFee(price)) * numberOfNight;
    }
    static float getAverage(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return (float) sum / numbers.length;
    }*/
}
