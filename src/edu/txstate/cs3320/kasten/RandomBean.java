package edu.txstate.cs3320.kasten;

import java.util.Random;

public class RandomBean {
    private static final Random RANDOM = new Random();

    public int getNextInt() {
        return RANDOM.nextInt(Integer.SIZE - 1);
    }
}