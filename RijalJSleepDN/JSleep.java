package RijalJSleepDN;

import java.util.Scanner;

//MODUL 1 PERKENALANm
public class JSleep {
    public static void main(String[] args) throws Exception {
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
        System.out.println("Testing getDiscountPercentage   : " + getDiscountPercentage(hargaAwal, hargaAkhir)+"%");
        System.out.println("Testing getDiscoutedPrice       : Rp" + getDiscountedPrice(hargaAwal, getDiscountPercentage(hargaAwal, hargaAkhir)));
        System.out.println("Testing getOriginalPrice        : Rp" + getOriginalPrice(getDiscountedPrice(hargaAwal, getDiscountPercentage(hargaAwal, hargaAkhir)), getDiscountPercentage(hargaAwal, hargaAkhir)));
        System.out.println("Testing getAdminFeePercentage   : " + getAdminFeePercentage()*100+"%");
        System.out.println("Testing getAdminFee             : Rp" + getAdminFee(hargaAwal));
        System.out.println("Testing getTotalPrice           : Rp" + getTotalPrice(hargaAwal, nights));
    }
    static int getHotelId(){
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
}
