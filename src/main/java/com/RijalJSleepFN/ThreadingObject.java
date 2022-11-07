package com.RijalJSleepFN;

public class ThreadingObject extends Thread {

    public ThreadingObject(String name){
        super(name);
    }


    @Override
    public void run(){
        System.out.println( Thread.currentThread().getName() + "  is running ");
        System.out.println("Thread " + this.getName() + " is running");
    }


}
