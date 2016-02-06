package lesson1.homework;

public class Frame10 {

	public static void main(String[] args) {

		String s = "Education is the most powerful weapon which you can use to change the world.";
		String t = "An investment in knowledge pays the best";
		String res = s.substring(s.indexOf("use"),s.indexOf("use")+4)+t.substring(t.indexOf("knowledge"),
		t.indexOf("knowledge")+10)+s.substring(s.indexOf("to"),s.length()-1);
		
		System.out.println(res);
	}

}
