package _04_Swapv2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Swpv2Test {

    @Test
    public void swp1() {
        var list = new ArrayList<Double>(Arrays.asList(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}));

        var result = Swpv2.Swpv2(1, 3, list);

        assertEquals(result, true);
        assertEquals(Arrays.asList(new Double[]{1.0, 4.0, 3.0, 2.0, 5.0}), list);
    }

    @Test
    public void swp2() {
        var list = new ArrayList<Double>(Arrays.asList(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}));

        var result = Swpv2.Swpv2(-1, 1, list);

        assertEquals(false, result);
    }

    @Test
    public void swp3() {
        var list = new ArrayList<Double>(Arrays.asList(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}));

        var result = Swpv2.Swpv2(0, 10, list);

        assertEquals(false, result);
    }
}