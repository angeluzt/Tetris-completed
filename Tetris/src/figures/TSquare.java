package figures;

import java.awt.Color;
import java.util.LinkedList;

import enummanager.EnumFigure;
import enummanager.Position;
import utils.Constants;

public class TSquare extends Figure {

	public TSquare() {
		super(Constants.T_QUARE, EnumFigure.T_SQUARE);

		this.setSquareLocation(Constants.COLUMNS / 3, 0);
	}
	
	public TSquare(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY) {
		super(color, baseX, baseY,squareSizeX, squareSizeY, EnumFigure.T_SQUARE);

		this.setSquareLocation(0, 0);
	}

	@Override
	public LinkedList<Square> rotateElement(Square[][] board) {
		LinkedList<Square> squares = new LinkedList<>();
		Square currentSQ;

		switch(this.getPosition()) {
			case UP:
				squares.add(currentSQ = this.getSquares().get(0).clone());

				currentSQ = this.getSquares().get(1);
				squares.add(
					currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);

				currentSQ = this.getSquares().get(2);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);
				currentSQ = this.getSquares().get(3);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() -1, currentSQ.getIndexJ() + 1, Constants.BOARD_X, Constants.BOARD_Y)
				);
				break;
			case RIGHT:
				currentSQ = this.getSquares().get(0);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 1, currentSQ.getIndexJ() + 1, Constants.BOARD_X, Constants.BOARD_Y)
				);
				squares.add(
						this.getSquares().get(1).clone()
				);
				squares.add(
						this.getSquares().get(2).clone()
				);
				squares.add(
						this.getSquares().get(3).clone()
				);
				break;
			case DOWN:
				currentSQ = this.getSquares().get(0);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ() - 1, Constants.BOARD_X, Constants.BOARD_Y)
				);
				currentSQ = this.getSquares().get(1);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);
				currentSQ = this.getSquares().get(2);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() - 1, currentSQ.getIndexJ(), Constants.BOARD_X, Constants.BOARD_Y)
				);
				squares.add(
						this.getSquares().get(3).clone()
				);
				break;
			case LEFT:
				squares.add(
						this.getSquares().get(0).clone()
				);
				currentSQ = this.getSquares().get(1);
				squares.add(
						this.getSquares().get(1).clone()
				);
				currentSQ = this.getSquares().get(2);
				squares.add(
						this.getSquares().get(2).clone()
				);
				currentSQ = this.getSquares().get(3);
				squares.add(
						currentSQ.clone().setLocation(currentSQ.getIndexI() + 1, currentSQ.getIndexJ() - 1, Constants.BOARD_X, Constants.BOARD_Y)
				);
				break;
		}
		return squares;
	}

	@Override
	public void setSquareLocation(int indexI, int indexJ) {
		this.addSquare(indexI + 1, indexJ);

		for(int i = 0; i < 3; i++) {
			this.addSquare(indexI++, indexJ + 1);
		}
	}

	@Override
	public void setNextPosition() {
		if(this.getPosition() == Position.UP) {
			this.setPosition(Position.RIGHT);
		} else if(this.getPosition() == Position.RIGHT){
			this.setPosition(Position.DOWN);
		} else if(this.getPosition() == Position.DOWN){
			this.setPosition(Position.LEFT);
		} else if(this.getPosition() == Position.LEFT){
			this.setPosition(Position.UP);
		}
	}
}
