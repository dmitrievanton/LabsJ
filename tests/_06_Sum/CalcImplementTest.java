package _06_Sum;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcImplementTest {

    Calculator calculator = new CalcImplement();

    @Test
    public void sum1() {

        var result = calculator.summa(-1,3);
        assertEquals(2, result);
    }

    @Test
    public void sum2() {
        var result = calculator.summa(10,0);
        assertEquals(10, result);
    }

    @Test
    public void sum3() {
        var result = calculator.summa(7,97);
        assertEquals(104, result);
    }

    @Test
    public void sum4() {
        var result = calculator.summa(0,8);
        assertEquals(8, result);
    }
}