
package com.RijalJSleepFN;

import java.util.ArrayList;

/**

 This is the Validate class. It contains a filter method that is used to
 filter a list of Price objects based on a given value and a boolean flag
 indicating whether to filter for values less than or greater than the given value.
 @author Ibrahim Rijal
 */
public class Validate {

    /**
     This is the filter method. It takes a list of Price objects, a value,
     and a boolean flag as input. It filters the list based on the value and
     the flag, and returns a new list containing only the elements that satisfy
     the filter criteria.
     @param list the list of Price objects to be filtered
     @param value the value used to filter the list
     @param less a boolean flag indicating whether to filter for values less than
     (`true`) or greater than (`false`) the given value
     @return a new list containing only the elements that satisfy the filter criteria
     */
    public static ArrayList filter (Price[] list, int value, boolean less){
        ArrayList filteredPrice = new ArrayList();
        if(less == true) {
            for (Price iterator : list) {
                if(iterator.price <= value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        else{
            for (Price iterator : list) {
                if(iterator.price > value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        return filteredPrice;
    }
}


