package _09_Ar_List;

import org.junit.Test;

import static org.junit.Assert.*;

public class Array_listTest {

    @Test
    public void delete1() {

        var list = new Array_list(new int[]{10, 6, 3, 4, 5, 2, 7, 3, 9, 10});

        list.deletepart(value -> value > 6);

        assertArrayEquals(new int[]{6, 3, 4, 5, 2, 3}, list.ToArray());
    }

    @Test
    public void delete2() {

        var list = new Array_list(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        list.deletepart(value -> value <= 9);

        assertArrayEquals(new int[]{10}, list.ToArray());
    }


    @Test
    //удаляем числа кратные 2
    public void deleteAll3() {

        var list = new Array_list(new int[]{ 10, 20, 30, 4, 5, 6, 70, 9, 13, 11});

        list.deletepart(value -> value % 2 == 0);

        assertArrayEquals(new int[]{5, 9, 13, 11}, list.ToArray());
    }
}