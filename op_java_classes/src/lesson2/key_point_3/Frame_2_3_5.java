package lesson2.key_point_3;

public class Frame_2_3_5 {

	/**
	 * - Tanks -
	 * @param args
	 */
	
	
	public static void main(String[] args) {
	
		printCoordinates("a", "9");
		printCoordinates("i", "0");
		printCoordinates("a", "1");
		printCoordinates("i", "9");
		printCoordinates("a", "3");
		printCoordinates("d", "6");
		printCoordinates("e", "7");

	}
	
	static void printCoordinates (String v, String h){
	String res = v+h+":("+getQuadrant(v, h).substring(0, getQuadrant(v, h).indexOf("_")) + "px; "+ 
	getQuadrant(v, h).substring(getQuadrant(v, h).indexOf("_")+1)+"px)";
	
	System.out.println(res);
}
	
	static String getQuadrant(String v, String h){
	String res = vPix(v) + "_" + hPix(h);
	return res;
	}
	
	static int vPix(String v){
		int px_sq = 64;
		String vLine = "abcdefghi";
		int vPix=vLine.indexOf(v)*px_sq;
		return vPix;
	}

	static int hPix(String h){
		int px_sq = 64;
		String hLine = "123456789";
		int hPix=hLine.indexOf(h)*px_sq;
		return hPix;
	}
	
		
//  version 2		
//	printCoordinates("a", "9");
//	
//	}
//	
//	static void printCoordinates (String v, String h){
//		String res = v+h+":("+getQuadrant(v, h).substring(0, getQuadrant(v, h).indexOf("_")) + "px; "+ 
//	getQuadrant(v, h).substring(getQuadrant(v, h).indexOf("_")+1)+"px)";
//		
//		System.out.println(res);
//	}
//
//	static String getQuadrant(String v, String h){
//		String res = vPix(v) + "_" + hPix(h);
//		return res;
//	}
//		
//	static int vPix(String v){
//		int px_sq = 64;
//		int i=0;
//		String [] vLine = new String[] {"a", "b","c","d","e","f","g","h","i"};
//
//		while(true){
//			if (vLine[i].equals(v)){
//				int vpix=i*px_sq;
//				return vpix;
//				} 
//			i++;
//		}
//	}
//	
//	static int hPix(String h){
//		int px_sq = 64;
//		int i = 0;
//		String [] hLine = new String[] {"1", "2","3","4","5","6","7","8","9"};
//		
//		while(true) {
//			if (hLine[i].equals(h)){
//				int hpix=i*px_sq;
//				return hpix;
//				}
//			i++;
//		}
//	}
}
