package com.RijalJSleepFN.dbjson;

import java.util.HashMap;


/**

 Class that represents a serializable object
 @author Ibrahim Rijal
 */
public class Serializable implements Comparable<Serializable> {
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();


    /**
     Constructor for a serializable object
     */
    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter =  0;
        }
        else{
            counter +=1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }


    /**
     Sets the closing ID for the specified class
     @param clazz the class whose closing ID is to be set
     @param id the value to set the closing ID to
     @return the previous value of the closing ID for the specified class
     */
    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) { return mapCounter.put(clazz, id); }

    /**
     Returns the closing ID for the specified class
     @param clazz the class whose closing ID is to be returned
     @return the closing ID for the specified class
     */
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) { return mapCounter.get(clazz); }


    /**
     Indicates whether some other object is "equal to" this one
     @param other the reference object with which to compare
     @return true if this object is the same as the other argument; false otherwise
     */
    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }


    /**
     Indicates whether some other serializable object is "equal to" this one
     @param other the reference object with which to compare
     @return true if this object is the same as the other argument; false otherwise
     */
    public boolean equals(Serializable other)
    {
        return other.id == id;
    }


    /**
     Compares this object with the specified object for order.
     @param other the object to be compared
     @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
     */
    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}
