package com.RijalJSleepFN.controller;

import com.RijalJSleepFN.Algorithm;
import com.RijalJSleepFN.dbjson.JsonTable;
import com.RijalJSleepFN.dbjson.Serializable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

/**

 This is an interface for a basic controller for a REST API for serializable objects.
 @param <T> the type of serializable object that the controller will handle

 */
@RestController
public interface BasicGetController <T extends Serializable> {


    /**
     This method gets an object with the specified ID from the JSON table.
     @param id the ID of the object to get
     @return the object with the specified ID, or null if no such object exists
     */
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        T object = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return object;
    }



    /**
     This method gets the JSON table for the serializable objects.
     @return the JSON table for the serializable objects
     */
    public abstract JsonTable<T> getJsonTable();



    /**
     This method gets a page of objects from the JSON table.
     @param page the number of the page to get (starting from 1)
     @param pageSize the number of objects to include in the page
     @return a page of objects from the JSON table
     */

    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam  int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }


}


