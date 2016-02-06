package lesson1.key_point4;

public class Frame_10 {

	public static void main(String[] args) {
		
		// thought that's what you mean:
		String mjQuote="I failed over and over again and over in my life and that is why I succeed";
		System.out.println(mjQuote.substring(mjQuote.length()-7,mjQuote.length()));
		
		// that's what it should probably look like:
		System.out.println(mjQuote.substring(mjQuote.indexOf("succeed"), mjQuote.indexOf("succeed")+7));
		
	}

}
