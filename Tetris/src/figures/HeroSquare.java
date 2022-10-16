package figures;

import java.awt.Color;
import java.util.LinkedList;

import enummanager.EnumFigure;
import enummanager.Position;
import utils.Constants;

public class HeroSquare extends Figure {

	public HeroSquare() {
		super(Constants.HERO, EnumFigure.HERO_SQUARE);

		this.setSquareLocation(Constants.COLUMNS / 3, 0);
	}
	
	public HeroSquare(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY) {
		super(color, baseX, baseY, squareSizeX, squareSizeY, EnumFigure.HERO_SQUARE);

		this.setSquareLocation(0, 0);
	}

	@Override
	public LinkedList<Square> rotateElement(Square[][] board) {
		LinkedList<Square> squares = new LinkedList<>();
		Square currentSQ;

		switch(this.getPosition()) {
			case UP, RIGHT:
				currentSQ = this.getSquares().get(0);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ() - 1, Constants.BOARD_X, Constants.BOARD_Y)
				);

				squares.add(this.getSquares().get(1).clone());

				currentSQ = this.getSquares().get(2).clone();
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 1, currentSQ.getIndexJ() + 1, Constants.BOARD_X, Constants.BOARD_Y)
				);

				currentSQ = this.getSquares().get(3).clone();
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 2, currentSQ.getIndexJ() + 2, Constants.BOARD_X, Constants.BOARD_Y)
				);
				break;
			case DOWN, LEFT:
				currentSQ = this.getSquares().get(0).clone();
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 1, currentSQ.getIndexJ() + 1, Constants.BOARD_X, Constants.BOARD_Y)
				);

				squares.add(this.getSquares().get(1).clone());

				currentSQ = this.getSquares().get(2).clone();
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ() - 1, Constants.BOARD_X, Constants.BOARD_Y)
				);

				currentSQ = this.getSquares().get(3).clone();
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 2, currentSQ.getIndexJ() - 2, Constants.BOARD_X, Constants.BOARD_Y)
				);
				break;
		}

		return squares;
	}

	@Override
	public void setSquareLocation(int indexI, int indexJ) {
		int i = 0;
		while(i < 4) {
			this.addSquare(indexI++, indexJ);
			i++;
		}
	}

	@Override
	public void setNextPosition() {
		
		if(this.getPosition() == Position.UP) {
			this.setPosition(Position.DOWN);
		} else {
			this.setPosition(Position.UP);
		}
	}
}
