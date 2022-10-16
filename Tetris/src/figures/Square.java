package figures;

import java.awt.Color;

public class Square {
	private int x, y;
	private int indexI, indexJ;
	private Color color;
	int width, height;

	public Square() {

	}

	public Square(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getIndexI() {
		return indexI;
	}

	public void setIndexI(int indexI) {
		this.indexI = indexI;
	}

	public int getIndexJ() {
		return indexJ;
	}

	public void setIndexJ(int indexJ) {
		this.indexJ = indexJ;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
	
	public Square setLocation(int baseX, int baseY) {		
		this.x = baseX + this.indexI * width;
		this.y = baseY + this.indexJ * height;
		
 		return this;
	}

	public Square setLocation(int i, int j, int baseX, int baseY) {
		this.indexI = i;
		this.indexJ = j;
		
		this.x = baseX + this.indexI * width;
		this.y = baseY + this.indexJ * height;
		
 		return this;
	}
	
	public Square clone() {
		Square square = new Square();

		square.setColor(this.color);
		square.setIndexI(this.indexI);
		square.setIndexJ(this.indexJ);
		square.setWidth(this.width);
		square.setHeight(this.height);
		square.setX(this.x);
		square.setY(this.y);
		
		return square;
	}
}
