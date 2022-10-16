package enummanager;

import java.util.Random;

public enum EnumFigure {
	O_SQUARE,
	HERO_SQUARE,
	L_SQUARE,
	J_SQUARE,
	T_SQUARE,
	Z_SQUARE,
	S_SQUARE;
	
    private static final Random PRNG = new Random();

    public static EnumFigure getRandomFigure()  {
    	EnumFigure[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}
