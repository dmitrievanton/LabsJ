package _05_Min_list;

import java.util.Collection;
import java.util.Comparator;

public class Min_list {
    public static <T> T findMin(Collection<T> collection, Comparator<? super T> comparator, long begin, long end){

        if(begin < 0 || end < 0){
            throw new IllegalArgumentException("начало и конец должны быть больше или равны нулю");
        }

        if(begin > end){
            throw new IllegalArgumentException("начало должно быть больше конца");
        }

        var count = end - begin;
        return collection.stream().skip(begin).limit(count).min(comparator).get();
    }
}
