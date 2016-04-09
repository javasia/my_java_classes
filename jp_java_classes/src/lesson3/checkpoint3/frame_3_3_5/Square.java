package lesson3.checkpoint3.frame_3_3_5;

public class Square extends Polygon {

	public Square() {
		xPoints = new int[] { 50, 200, 200, 50 };
		yPoints = new int[] { 50, 50, 200, 200 };
		points = 4;
		
	}

	public Square(int[] xPoints, int[] yPoints, int points) {
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.points = points;
	}
}
