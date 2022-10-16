package figures;

import java.util.Random;

import enummanager.EnumFigure;
import utils.Constants;

public class SquareFactory {

	public static int generateRandom(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}
	
	public static Figure getRegularFigure() {
		EnumFigure figure = EnumFigure.getRandomFigure();
		
		switch (figure) {
		case O_SQUARE:
			return new OSquare();
		case HERO_SQUARE:
			return new HeroSquare();
		case L_SQUARE:
			return new LSquare();
		case J_SQUARE:
			return new JSquare();
		case T_SQUARE:
			return new TSquare();
		case Z_SQUARE:
			return new ZSquare();
		case S_SQUARE:
			return new SSquare();
		default:
			return null;
		}
	}
	
	public static Figure getRegularFigure(EnumFigure figure) {
		
		switch (figure) {
		case O_SQUARE:
			return new OSquare();
		case HERO_SQUARE:
			return new HeroSquare();
		case L_SQUARE:
			return new LSquare();
		case J_SQUARE:
			return new JSquare();
		case T_SQUARE:
			return new TSquare();
		case Z_SQUARE:
			return new ZSquare();
		case S_SQUARE:
			return new SSquare();
		default:
			return null;
		}
	}

	public static Figure getViewFigure(EnumFigure figure, int baseX, int baseY, int width, int height) {
		switch (figure) {
		case O_SQUARE:
			return new OSquare(Constants.O_QUARE, baseX, baseY, width, height);
		case HERO_SQUARE:
			return new HeroSquare(Constants.HERO, baseX, baseY, width, height);
		case L_SQUARE:
			return new LSquare(Constants.L_QUARE, baseX, baseY, width, height);
		case J_SQUARE:
			return new JSquare(Constants.J_QUARE, baseX, baseY, width, height);
		case T_SQUARE:
			return new TSquare(Constants.T_QUARE, baseX, baseY, width, height);
		case Z_SQUARE:
			return new ZSquare(Constants.Z_QUARE, baseX, baseY, width, height);
		case S_SQUARE:
			return new SSquare(Constants.S_QUARE, baseX, baseY, width, height);
		}
		
		return null;
	}
}
