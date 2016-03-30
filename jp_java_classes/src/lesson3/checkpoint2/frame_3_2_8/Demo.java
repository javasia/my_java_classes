package lesson3.checkpoint2.frame_3_2_8;

public class Demo {
	
	public static void main(String[] args) {
		Square square = new Square();
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		Triangle triangle = new Triangle();


		
		Shape[] shapes = new Shape[4];
		shapes[0]=circle;
		shapes[1]=rectangle;
		shapes[2]=triangle;
		shapes[3]=square;
		
		
		new ShapesTemplate(shapes);
	}

}
