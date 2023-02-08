package utilities;

import java.util.Random;

public class BetterRand {



    public static int randInRange(int min, int max){

        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }
}
