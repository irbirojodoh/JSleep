package com.RijalJSleepFN;

/**
 @author Ibrahim Rijal
 This is the Predicate interface. It is used to define a custom
 method for testing an object of type T.
 @param <T> the type of the object to be tested by the predicate method
 */
public interface Predicate <T> {

    /**
    This is the predicate method. It must be implemented by any class
    that implements the Predicate interface. It takes an object of
    type T as input and returns a boolean value indicating whether
    or not the object satisfies some condition defined by the implementing class.
    @param predicate the object to be tested
    @return a boolean value indicating whether or not the object satisfies some condition
    */
    public boolean predicate(T predicate);


}
