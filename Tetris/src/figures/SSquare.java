package figures;

import java.awt.Color;
import java.util.LinkedList;

import enummanager.EnumFigure;
import enummanager.Position;
import utils.Constants;

public class SSquare extends Figure {

	public SSquare() {
		super(Constants.S_QUARE, EnumFigure.Z_SQUARE);

		this.setSquareLocation(Constants.COLUMNS / 3, 0);
	}
	
	public SSquare(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY) {
		super(color, baseX, baseY, squareSizeX, squareSizeY, EnumFigure.Z_SQUARE);

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
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);
				currentSQ = this.getSquares().get(1);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 2, currentSQ.getIndexJ() + 1, Constants.BOARD_X, Constants.BOARD_Y)
				);

				currentSQ = this.getSquares().get(2);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);
				currentSQ = this.getSquares().get(3);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI(), currentSQ.getIndexJ() + 1, Constants.BOARD_X, Constants.BOARD_Y)
				);
				break;
			case DOWN, LEFT:
				currentSQ = this.getSquares().get(0);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);
				currentSQ = this.getSquares().get(1);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 2, currentSQ.getIndexJ() - 1, Constants.BOARD_X, Constants.BOARD_Y)
				);

				currentSQ = this.getSquares().get(2);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);
				currentSQ = this.getSquares().get(3);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI(), currentSQ.getIndexJ() - 1, Constants.BOARD_X, Constants.BOARD_Y)
				);
				break;
		}
		return squares;
	}

	@Override
	public void setSquareLocation(int indexI, int indexJ) {
		this.addSquare(indexI + 1, indexJ);
		this.addSquare(indexI + 2, indexJ);
		this.addSquare(indexI, indexJ + 1);
		this.addSquare(indexI + 1, indexJ + 1);
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
