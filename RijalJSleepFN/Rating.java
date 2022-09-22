package RijalJSleepFN;

public class Rating {
    private long total;
    private long count;


    public Rating(){
        this.total = 0;
        this.count = 0;
    }
    public void insert(int rating){
        this.total += rating;
        count++;
    }
    public double getAverage(){
        if(this.count == 0){
            System.out.println("var this kosong");
        }else{
        return (double) this.total / this.count;
        }
        return 0;
    }
    public long getCount(){
        return this.count;
    }
    public long getTotal(){
        return this.total;
    }
}
