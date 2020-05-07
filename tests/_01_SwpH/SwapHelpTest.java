package _01_SwpH;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapHelpTest {

    @Test
    public void swap1() {
        int[] anArray = new int[]{1, 2, 3, 4, 5};

        var result = SwapHelp.Swap(2, 4, anArray);

        assertEquals(true, result);
        assertArrayEquals(anArray, new int[]{1, 2, 5, 4, 3});
    }

    @Test
    public void swap2() {
        int[] anArray = new int[]{1, 2, 3, 4, 5};

        var result = SwapHelp.Swap(-1, 3, anArray);

        assertEquals(false, result);
    }

    @Test
    public void swap3() {
        int[] anArray = new int[]{1, 2, 3, 4, 5};

        var result = SwapHelp.Swap(1, 30, anArray);

        assertEquals(false, result);
    }

    @Test
    public void swap4() {
        int[] anArray = new int[]{1, 2, 3, 4, 5};

        var result = SwapHelp.Swap(2, 2, anArray);

        assertEquals(true, result);
    }

    @Test
    public void swap5() {

        var result = SwapHelp.Swap(0, 0, null);

        assertEquals(false,result);
    }

}