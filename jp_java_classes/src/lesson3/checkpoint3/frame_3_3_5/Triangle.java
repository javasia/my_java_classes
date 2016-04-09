package lesson3.checkpoint3.frame_3_3_5;

public class Triangle extends Polygon {

	public Triangle() {
		xPoints = new int[] { 50, 100, 150 };
		yPoints = new int[] { 150, 50, 150 };
		points = 3;
	}

	public Triangle(int[] xPoints, int[] yPoints, int points) {
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.points = points;
	}
}
