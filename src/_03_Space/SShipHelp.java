package _03_Space;

import _03_Space.SShip;

import java.util.Collection;

public class SShipHelp{
    public static double avgSpeed(Collection<SShip> spaceships){
        return spaceships.stream().mapToDouble(SShip::getSpeed).average().getAsDouble();
    }

    public static double minSpeed(Collection<SShip> spaceships){
        return spaceships.stream().mapToDouble(SShip::getSpeed).min().getAsDouble();
    }
}