package tests;

public class Switch {

	public static void main(String[] args) {

		switch (10){// int, enum, String
		case 0:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 4:
			System.out.println("4");
			break;
		case 3:
			System.out.println("3");
			break;
		default:
			System.out.println(-1);
		}
		
	}

}
