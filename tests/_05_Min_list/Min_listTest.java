package _05_Min_list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class Min_listTest {

    @Test
    public void findMin1() {

        var list = Arrays.asList(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0});
        var result = Min_list.findMin(list, Double::compareTo, 1, 4);

        assertEquals(2.0, result, 0.00000001);
    }

    @Test
    public void findMin2() {

        var list = Arrays.asList(new Double[]{6.0, 5.0, 4.0, 3.0, 2.0, 1.0});
        var result = Min_list.findMin(list, Double::compareTo, 1, 4);

        assertEquals(3.0, result, 0.00000001);
    }

}