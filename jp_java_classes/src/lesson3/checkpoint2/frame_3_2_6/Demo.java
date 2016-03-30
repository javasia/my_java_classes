package lesson3.checkpoint2.frame_3_2_6;

public class Demo {
	
	public static void main(String[] args) {
		Oval oval = new Oval();
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		Triangle triangle = new Triangle();

		
		Shape[] shapes = new Shape[3];
		shapes[0]=circle;
		shapes[1]=rectangle;
		shapes[2]=triangle;
		//shapes[3]=oval;
		
		
		new ShapesTemplate(shapes);
	}

}
