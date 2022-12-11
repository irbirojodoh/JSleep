package com.RijalJSleepFN;
/**

 This is the Rating class. It is used to calculate the average rating
 of a group of ratings.
 @author Ibrahim Rijal
 */
public class Rating {
    private long total;
    private long count;

    /**
     This is the constructor for the Rating class. It initializes the
     total and count instance variables to 0.
     */
    public Rating(){
        this.total = 0;
        this.count = 0;
    }
    /**
     This method is used to insert a new rating into the group of ratings.
     @param rating the rating to be added to the group
     */
    public void insert(int rating){
        this.total += rating;
        count++;
    }

    /**
     This method is used to calculate the average of the group of ratings.
     If there are no ratings in the group, it prints a message to the console
     and returns 0.
     @return the average of the group of ratings
     */
    public double getAverage(){
        if(this.count == 0){
            System.out.println("var this kosong");
        }else{
        return (double) this.total / this.count;
        }
        return 0;
    }
    /**
     This method is used to get the number of ratings in the group.
     @return the number of ratings in the group
     */
    public long getCount(){
        return this.count;
    }

    /**
     This method is used to get the sum of the ratings in the group.
     @return the sum of the ratings in the group
     */
    public long getTotal(){
        return this.total;
    }

    /**
     This method is used to create a string representation of the Rating
     object.
     @return a string representation of the Rating object
     */
    public String toString() {
        return "count=" + this.count + ", total=" + this.total ;
    }
    
}
