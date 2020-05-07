package _02_Min3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Min3Test {

    @Test
    public void minimum1() {
        var result = Min3.min(4,2,7);

        assertEquals(2,result);
    }

    @Test
    public void minimum2() {
        var result = Min3.min(5,18,9);

        assertEquals(5,result);
    }

    @Test
    public void minimum3() {
        var result = Min3.min(6,7,1);

        assertEquals(1,result);
    }
}