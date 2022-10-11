package RijalJSleepFN;

import java.util.*;

public class Algorithm {


    private Algorithm() {
        //do nothing
    }








    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current)){
                return true;
            }
        }

        return false;
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }
    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }



//===========================================================


    public static <T> int count(Iterator<T> iterator, T t_var){
        int count = 0;
        while (iterator.hasNext()){
            if(iterator.next().equals(t_var)){
                count++;
            }
        }
        return count;
    }

    public static int count(int[] arr, int t_var) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t_var) {
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterable<T> iter, Predicate<T> predicate) {
        int count = 0;
        for (T t_var : iter) {
            if (predicate.predicate(t_var)) {
                count++;
            }
        }
        return count;
    }

    public static <T> int count(T[] arr, Predicate<T> predicate) {
        int count = 0;
        for (T t_var : arr) {
            if (predicate.predicate(t_var)) {
                count++;
            }
        }
        return count;
    }


    public static <T> int count(Iterator<T> iterator, Predicate<T> predicate) {
        int count = 0;
        while (iterator.hasNext()) {
            if (predicate.predicate(iterator.next())) {
                count++;
            }
        }
        return count;
    }



    public static <T> int count(Iterable<T> iterable, T t_var) {
        int count = 0;
        for (T t : iterable) {
            if (t.equals(t_var)) {
                count++;
            }
        }
        return count;
    }


    //============================================================
    public static <T> T find(T[] arr, Predicate<T> predicate) {
        for (T t_var : arr) {
            if (predicate.predicate(t_var)) {
                return t_var;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> predicate) {
        for (T t_var : iterable) {
            if (predicate.predicate(t_var)) {
                return t_var;
            }
        }
        return null;
    }



    public static <T> T find(T[] arr, T t_var) {
        for (T t : arr) {
            if (t.equals(t_var)) {
                return t;
            }
        }
        return null;
    }


    public static <T> T find(Iterable<T> iterable, T t_var) {
        for (T t : iterable) {
            if (t.equals(t_var)) {
                return t;
            }
        }
        return null;
    }


    public static <T> T find(Iterator<T> iterator, T t_var){
        while (iterator.hasNext()){
            T current = iterator.next();
            if(current.equals(t_var)){
                return current;
            }
        }
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> predicate){
        while (iterator.hasNext()){
            T current = iterator.next();
            if(predicate.predicate(current)){
                return current;
            }
        }
        return null;
    }

}