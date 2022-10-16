package components;

import java.awt.Graphics;

import figures.Figure;
import figures.Square;
import segregation.Drawable;
import utils.Constants;

public class ViewFigure implements Drawable {

	private int x, y;
	private Figure figure;

	public ViewFigure() {
		
	}
	
	public ViewFigure(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paintElement(Graphics g) {
		/*g.setColor(Color.BLACK);
		g.drawRect(x, y, Constants.WIDTH_OF_VIEW, Constants.HEIGHT_OF_VIEW);*/
		
		if(this.figure != null && !this.figure.getSquares().isEmpty()) {
			for (Square square: this.figure.getSquares()) {
				g.setColor(square.getColor());
				g.fill3DRect(square.getX(), square.getY(), Constants.WIDTH_OF_SQUARE_VIEW, Constants.HEIGHT_OF_SQUARE_VIEW, true);
			}			
		}
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

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
}
