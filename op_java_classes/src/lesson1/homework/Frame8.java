package lesson1.homework;

public class Frame8 {

	public static void main(String[] args) {

	double value=20.55555;
	
	String str_value = String.valueOf(value);
		
	System.out.println(str_value.substring(0, str_value.indexOf(".")));
	System.out.println(str_value.substring(str_value.indexOf(".")+1));

	}

}
