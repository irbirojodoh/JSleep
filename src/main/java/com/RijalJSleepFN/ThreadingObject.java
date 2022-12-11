package com.RijalJSleepFN;


/**

 This is the ThreadingObject class. It is used to create a new thread.
 @author RijalJSleepFN
 */
public class ThreadingObject extends Thread {


    /**
     This is the constructor for the ThreadingObject class. It takes a
     name parameter and passes it to the superclass's constructor to
     initialize the thread's name.
     @param name the name of the thread
     */
    public ThreadingObject(String name){
        super(name);
    }



    /**
     This is the run method. It is called when the thread is started
     and contains the code that the thread will execute. In this case,
     it simply prints a message to the console indicating that the thread
     is running.
     */
    @Override
    public void run(){
        System.out.println( Thread.currentThread().getName() + "  is running ");
        System.out.println("Thread " + this.getName() + " is running");
    }


}
