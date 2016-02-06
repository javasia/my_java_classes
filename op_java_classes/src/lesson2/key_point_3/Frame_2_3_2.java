package lesson2.key_point_3;

/**
 *- TANKS - 
 * @author Rat
 *
 */


public class Frame_2_3_2 {
	
	
	
	public static void main(String[] args) {
 
		System.out.println(getQuadrant("a","1"));
		System.out.println(getQuadrant("b","2"));
		System.out.println(getQuadrant("c","3"));
		System.out.println(getQuadrant("h","9"));
		System.out.println(getQuadrant("a","2"));
		System.out.println(getQuadrant("i","1"));
		System.out.println(getQuadrant("i","9"));

	}

	//version 1
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

	
	
	
	// version 2
//		static String getQuadrant(String v, String h){
//			String res = vPix(v) + "_" + hPix(h);
//			return res;
//		}
//
//		
//		static int vPix(String v){
//			int px_sq = 64;
//			int i=0;
//			String [] vLine = new String[] {"a", "b","c","d","e","f","g","h","i"};
//
//			while(true){
//				if (vLine[i].equals(v)){
//					int vpix=i*px_sq;
//					return vpix;
//					} 
//				i++;
//			}
//		}
//		
//		static int hPix(String h){
//			int px_sq = 64;
//			int i = 0;
//			String [] hLine = new String[] {"1", "2","3","4","5","6","7","8","9"};
//			
//			while(true) {
//				if (hLine[i].equals(h)){
//					int hpix=i*px_sq;
//					return hpix;
//					}
//				i++;
//			}
//		}
}