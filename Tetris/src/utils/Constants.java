package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Constants {

	public static final int BOARD_X = 500;
	public static final int BOARD_Y = 100;
	public static final int BOARD_WIDTH = 500;
	public static final int BOARD_HEIGHT = 700;
	public static final int COLUMNS = 10;
	public static final int ROWS  = 20;

	public static final int SQUARE_WIDTH = BOARD_WIDTH / COLUMNS;
	public static final int SQUARE_HEIGHT  = BOARD_HEIGHT / ROWS;

	public static final int WIDTH_OF_VIEW = (int)(Constants.BOARD_WIDTH * 0.3);
	public static final int HEIGHT_OF_VIEW = (int)(Constants.BOARD_WIDTH * 0.1);
	public static final int WIDTH_OF_SQUARE_VIEW = (int) (WIDTH_OF_VIEW * 0.2);
	public static final int HEIGHT_OF_SQUARE_VIEW = (int) (HEIGHT_OF_VIEW * 0.5);

	public static final int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static final int FONT_SIZE = (int)(Constants.HEIGHT_OF_VIEW * 0.8);
	public static Font FONT = new Font("TimesRoman", Font.PLAIN, FONT_SIZE);
	
	public static Color HERO = Color.CYAN;
	public static Color S_QUARE = Color.GREEN;
	public static Color Z_QUARE = Color.RED;
	public static Color J_QUARE = Color.BLUE;
	public static Color L_QUARE = Color.ORANGE;
	public static Color O_QUARE = Color.YELLOW;
	public static Color T_QUARE = Color.MAGENTA;
}