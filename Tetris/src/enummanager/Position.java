package enummanager;

import java.util.Random;

public enum Position {
	RIGHT,
	LEFT,
	UP,
	DOWN;

    private static final Random PRNG = new Random();

    public static Position randomDirection()  {
    	Position[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}
