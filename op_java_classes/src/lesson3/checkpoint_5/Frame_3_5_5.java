package lesson3.checkpoint_5;

public class Frame_3_5_5 {

	public static void main(String[] args) {

		System.out.println(inverse("AbCdEfGhI"));
		System.out.println(inverse("AbCdEfGh"));

		System.out.println(inverse(null));

	}

	static String inverse(String str) {

		if (str == null) {
			return "Illegal parameters!";
		}

		char[] chArray = str.toCharArray();

		for (int i = 0, j = 0; j < chArray.length; i++, j += 2) {
			char temp = chArray[i];
			chArray[i] = chArray[chArray.length - 1 - i];
			chArray[chArray.length - 1 - i] = temp;
		}
		str = new String(chArray);
		return str;
	}

}
