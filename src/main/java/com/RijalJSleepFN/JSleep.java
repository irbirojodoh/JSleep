package com.RijalJSleepFN;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * JSleep is the main method class
 * @author Ibrahim Rijal
 * @version 11-04-2022
 */
@SpringBootApplication
public class JSleep {

    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static Room createRoom() {
        Price price = new Price(100000.0, 5);
        Room room = new Room(12, "Restaurant", 30, price, Facility.AC, City.JAKARTA, "Jl.Medan");
        return room;
    }





    public static void main(String[] args) {
        SpringApplication.run(JSleep.class, args);

        /* BEKAS MODUL 6 [PT
        for (int i = 0; i < 10; i++) {
            ThreadingObject thread = new ThreadingObject("Thread " + i);
            thread.start();
        }
        Account testRegex = new Account("rijal", "ibrahimrijal@ui.ac.id", "kudaLi@r69");
        Account testRegexFail = new Account( "bangFaten", "faten.gntg@ui.com", "1223343232");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());




        try {
            String filepath = "src/json/";
            //JsonTable<Account> tableAccount = new JsonTable<Account>(Account.class, filepath );
            //FileWriter jsonWriter = new FileWriter(filepath + "account.json");
            //jsonWriter.close();
            JsonTable<Account> tableAccount = new JsonTable<Account>(Account.class, filepath + "account.json");
            tableAccount.add(testRegex);
            tableAccount.writeJson();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    */
    }

    /* METHOD UNTUK MODUL 6 [PT
    public static List<Room> filterByCity(List<Room> list, String city,int page,int pagesize){
        List<Room> filtered = new ArrayList<Room>();
        filtered = Algorithm.<Room>paginate(list,page,pagesize,a -> a.city == City.valueOf(city.toUpperCase()));
        return filtered;
    }

    public static List<Room> filterByPrice(List<Room> list, double min,double max){
        List<Room> filtered = new ArrayList<Room>();
        filtered = Algorithm.<Room>collect(list,i -> ((i.price.price >= min) && (i.price.price <= max)));
        return filtered;
    }

    public static List<Room> filterByAccountId(List<Room> list,int accountId,int page,int pagesize){
        List<Room> filtered = new ArrayList<Room>();
        filtered = Algorithm.<Room>paginate(list,page,pagesize,i -> i.accountId == accountId);
        return filtered;
    }
    */
}


/*
        String filepath = "/Users/rijal/Documents/OOPLOCAL/Praktikum/BlueJ/Praktikum-JSleep/JSleep/src/city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(states -> System.out.println(states));;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        */

        //testing commit push dari intelij
        /*
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 20");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 18 hingga 20");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 18 hingga 20 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        */
        //System.out.println(RoomA.booked);


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



