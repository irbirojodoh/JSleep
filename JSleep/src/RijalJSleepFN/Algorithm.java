package RijalJSleepFN;

import java.util.*;

public class Algorithm {


    private Algorithm() {
        //do nothing
    }
    //exist===============================================================
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


    // count===========================================================

    public static <T> int count(Iterator<T> iterator, T t_var){
        final Predicate<T> pred = t_var::equals;
        return count(iterator, pred);
    }
    public static <T> int count(T[] arr, T t_var) {
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return count(it, t_var);
    }
    public static <T> int count(Iterable<T> iter, Predicate<T> predicate) {
        final Iterator<T> it = iter.iterator();
        return count(it, predicate);
    }
    public static <T> int count(T[] arr, Predicate<T> predicate) {
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return count(it, predicate);
    }
    public static <T> int count(Iterator<T> iterator, Predicate<T> predicate) {
       int count = 0;
        while (iterator.hasNext()){
            T current = iterator.next();
            if(predicate.predicate(current)){
                count++;
            }
        }
        return count;
    }
    public static <T> int count(Iterable<T> iterable, T t_var) {
        final Iterator<T> it = iterable.iterator();
        return count(it, t_var);
    }


    //find ============================================================
    public static <T> T find(T[] arr, Predicate<T> predicate) {
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return find(it, predicate);
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> predicate) {
        final Iterator<T> it = iterable.iterator();
        return find(it, predicate);
    }
    public static <T> T find(T[] arr, T t_var) {
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return find(it, t_var);
    }
    public static <T> T find(Iterable<T> iterable, T t_var) {
        final Iterator<T> it = iterable.iterator();
        return find(it, t_var);
    }
    public static <T> T find(Iterator<T> iterator, T t_var){
        final Predicate<T> pred = t_var::equals;
        return find(iterator, pred);
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

    //collect============================================================
    public static <T> List<T> collect(Iterable<T>iter, T t_var){
        final Predicate<T> pred = t_var::equals;
        return collect(iter.iterator(), pred);
    }
    public static <T> List<T>  collect(Iterable<T> iter, Predicate<T> predicate) {
        final Iterator<T> it = iter.iterator();
        return collect(it, predicate);
    }
    public static <T> List<T> collect(T[] arr, T t_var){
        final Predicate<T> predicate = t_var::equals;
        return collect(Arrays.stream(arr).iterator(), predicate);
    }
    public static <T> List<T> collect(Iterator <T> iterator, T t_var ){
        final Predicate<T> predicate = t_var::equals;
        return collect(iterator, predicate);
    }
    public static <T> List<T> collect(T[] arr, Predicate<T> predicate){
        final Iterator<T> iterator = Arrays.stream(arr).iterator();
        return collect(iterator, predicate);
    }
    public static <T> List<T> collect(Iterator <T> iter, Predicate <T> pred){
        List<T> list = new ArrayList<>();
        while (iter.hasNext()){
            T current = iter.next();
            if(pred.predicate(current)){
                list.add(current);
            }
        }
        return list;
    }

    //paginate============================================================
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        int count = 0;
        int index = 0;
        while (iterator.hasNext()){
            T current = iterator.next();
            if(predicate.predicate(current)){
                if(index >= page && count < pageSize){
                    list.add(current);
                    count++;
                }
                index++;
            }
        }
        return list;
    }

    public static <T> List<T> paginate(T[] arr, int page, int pageSize, Predicate<T> predicate){
        final Iterator<T> iterator = Arrays.stream(arr).iterator();
        return paginate(iterator, page, pageSize, predicate);
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> predicate){
        final Iterator<T> iterator = iterable.iterator();
        return paginate(iterator, page, pageSize, predicate);
    }
}