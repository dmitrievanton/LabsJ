package _09_Ar_List;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Array_list {

    public Array_list(int[] collection){
        //для задания не требуется создание полноценного класса, поэтому прибегним к инициализации через collection
        array  = collection;
        size = array.length;
    }

    private int[] array;
    private int size;
    //будем проходить по массивам тестами с разными условиями
    public void deletepart(IntPredicate predicate){

        var count = (int) Arrays.stream(array).filter(predicate).count();
        //если нечего удалять
        if(count == 0){
            return;
        }

        //пересоздаем массив
        var newSize = size - count;
        var copyArray = new int[newSize];
        int i = 0;

        for (var value : array) {
            if(!predicate.test(value)){
                copyArray[i] = value;
                i++;
            }
        }

        array = copyArray;
        size = array.length;
    }

    public int[] ToArray(){
        return array;
    }
}