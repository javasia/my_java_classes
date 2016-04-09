package lesson3.checkpoint3.frame_3_3_5;

import java.awt.Color;

public class Demo {

	public static void main(String[] args) {
		Triangle triangle = new Triangle();
		triangle.setColor(Color.BLUE);
		
		
		Square square2 = new Square(new int[]{250, 450, 450, 250},new int[]{50, 50, 250, 250},4);
		square2.setColor(Color.PINK);
		triangle.setColor(Color.GREEN);
		Circle circle = new Circle(300, 300, 100, 100);
		circle.setStrokeThickness(15);
		circle.setColor(Color.MAGENTA);
		Rectangle rectangle = new Rectangle();
		rectangle.setColor(Color.ORANGE);
		rectangle.setStrokeThickness(10);

		AbstractShape[] shapes = new AbstractShape[4];
		shapes[0] = rectangle;
		shapes[1]=square2;
		shapes[2]=triangle;
		shapes[3]=circle;
		

		new ShapesTemplate(shapes);
	}

}
