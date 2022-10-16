package figures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import enummanager.EnumFigure;
import enummanager.Position;
import segregation.Drawable;
import utils.Constants;

public abstract class Figure implements Drawable {
	private LinkedList<Square> squares = new LinkedList<>();
	private Color color;
	private Position position;
	private int width, height;
	private int baseX, baseY;
	private EnumFigure figureType;

	public Figure() {
		this.position = Position.randomDirection();
	}

	// Constructor for regular figure
	public Figure(Color color, EnumFigure figureType) {
		this.position = Position.UP;
		this.color = color;
		this.baseX = Constants.BOARD_X;
		this.baseY = Constants.BOARD_Y;
		this.figureType = figureType;
		
		// Use the board location
		this.width = Constants.SQUARE_WIDTH;
		this.height = Constants.SQUARE_HEIGHT;
	}

	// Constructor for figure inside an specific location and size
	public Figure(Color color, int baseX, int baseY, int width, int height, EnumFigure figureType) {
		this.position = Position.UP;
		this.color = color;
		this.baseX = baseX;
		this.baseY = baseY;
		this.width = width;
		this.height = height;
		
		this.figureType = figureType;
	}

	@Override
	public void paintElement(Graphics g) {
		g.setColor(this.color);
		for (Square square: this.getSquares()) {
			g.fill3DRect(square.getX(), square.getY(), width, height, true);
		}
	}

	public void addSquare(int i, int j) {
		this.squares.add(new Square(this.getColor(), this.getWidth(), this.getHeight()).setLocation(i, j, baseX, baseY));
	}

	public void addSquare(Square square) {
		squares.add(square);
	} 
	public LinkedList<Square> getSquares() {
		return squares;
	}
	public void setSquares(LinkedList<Square> squares) {
		this.squares = squares;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBaseX() {
		return baseX;
	}

	public void setBaseX(int baseX) {
		this.baseX = baseX;
	}

	public int getBaseY() {
		return baseY;
	}

	public void setBaseY(int baseY) {
		this.baseY = baseY;
	}

	public EnumFigure getFigureType() {
		return figureType;
	}

	public void setFigureType(EnumFigure figureType) {
		this.figureType = figureType;
	}

	public abstract LinkedList<Square> rotateElement(Square[][] board);
	public abstract void setSquareLocation(int indexI, int indexJ);
	
	public abstract void setNextPosition();
}
