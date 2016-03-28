package lesson3.checkpoint2.frame_3_2_2.shapes;

public class Demo {
	
	public static void main(String[] args) {
		Oval oval = new Oval();
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		Triangle triangle = new Triangle();

		Painter painter = new Painter(); 
		painter.draw(circle);
		painter.draw(rectangle);
		painter.draw(triangle);
		painter.draw(oval);
		
	}

}
