package lesson3.checkpoint2.frame_3_2_15;

public class RoundGlyph extends Glyph{
	
	private int radius=5;
	
	public RoundGlyph(int radius) {
		System.out.println("RaundGlyph#constructor(int radius)");
		draw();
		this.radius=radius;
	}
	
	@Override
	void draw() {
		System.out.println("RoundGlyph#draW()");
		System.out.println("RoundGlyph [radius: " + radius + "]");
	}
	

}
