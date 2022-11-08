package com.RijalJSleepFN.controller;

import com.RijalJSleepFN.Algorithm;
import com.RijalJSleepFN.dbjson.JsonTable;
import com.RijalJSleepFN.dbjson.Serializable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;
@RestController

public interface BasicGetController<T extends Serializable> {
    @GetMapping("/{id}")

    public default T getById(@PathVariable int id){
        T obj = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return obj;
    }
    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    public abstract JsonTable<T> getJsonTable();




}

