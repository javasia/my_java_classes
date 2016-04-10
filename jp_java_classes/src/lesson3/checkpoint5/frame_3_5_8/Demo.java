package lesson3.checkpoint5.frame_3_5_8;

public class Demo {

	public static void main(String[] args) {
		Init init = new Init();
		Menu menu = new Menu(init.createProducts());
		menu.printMenu();
	}
}
