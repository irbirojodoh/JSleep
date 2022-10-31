package RijalJSleepFN;

import java.util.HashMap;

public class Serializable {

    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    /** */
 protected Serializable(){
    // mapCounter = new HashMap<>();
    Integer count = mapCounter.get(getClass());
    if (count == null){
        count = 0;
    }else{
        count++;
    }
  mapCounter.put(this.getClass(), count);
    this.id = count;
 }

    public boolean equals(Object obj){
        if (obj instanceof Serializable && ((Serializable)obj).id == this.id){
            return true ;
        }
        return false;
    }

   public boolean equals (Serializable o){
        if (o.id == this.id){
            return true ;
        }
        return false;
    }

    public int compareTo (Serializable ser){
        if (ser.id > this.id){
            return 1;
        }else if(ser.id == this.id) {
            return 0;
        }else {
            return -1;
        }

    }

    public static <T> Integer getClosingId(Class<T> t) {
        return mapCounter.get(t);
    }

    public static <T> Integer setClosingId(Class<T> t, int id){
        return mapCounter.put(t, id);
    }
}
