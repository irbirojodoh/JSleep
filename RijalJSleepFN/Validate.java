
package RijalJSleepFN;

import java.util.ArrayList;

public class Validate {
    

    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList<Double> result = new ArrayList<Double>();
       // ArrayList<Price> lesser = new ArrayList<Price>();
       // ArrayList<Price> greater = new ArrayList<Price>();
        int i, size = list.length;
        for(i = 0; i< list.length; i++){
            if (less){
                if (list[i].price <= value){
                    result.add(list[i].price);
                }
            }
            else{
                if (list[i].price > value){
                result.add(list[i].price);
                }
            }
        }
        
        return result;

    }
}


