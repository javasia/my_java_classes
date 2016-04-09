package lesson3.checkpoint3.frame_3_3_5;

public class Rectangle extends Polygon {

	public Rectangle() {
		xPoints = new int[] { 50, 200, 200, 50 };
		yPoints = new int[] { 50, 50, 100, 100 };
		points = 4;
	}

	public Rectangle(int[] xPoints, int[] yPoints, int points) {
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.points = points;
	}
}
