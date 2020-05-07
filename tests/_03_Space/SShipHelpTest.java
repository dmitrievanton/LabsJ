package _03_Space;

import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SShipHelpTest {

    @Test
    public void avgSpeed() {
        var list = new ArrayList<SShip>();
        list.add(new SShip(50));
        list.add(new SShip(20));
        list.add(new SShip(20));

        var result = SShipHelp.avgSpeed(list);

        assertEquals(30, result, 0.00000001);
    }


    @Test
    public void minSpeed() {
        var list = new ArrayList<SShip>();
        list.add(new SShip(25));
        list.add(new SShip(5));
        list.add(new SShip(17));

        var result = SShipHelp.minSpeed(list);

        assertEquals(5, result, 0.00000001);
    }
}