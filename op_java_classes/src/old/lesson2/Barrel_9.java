package old.lesson2;

/**
 *- TANKS - 
 * @author Rat
 *
 */


public class Barrel_9 {
	
	
	
	public static void main(String[] args) {
 
		System.out.println(getQuadrant("c","2"));
	}

		static String getQuadrant(String v, String h){
			String res = vPix(v) + "_" + hPix(h);
			return res;
		}
			
		static int vPix(String v){
			int px_sq = 64;
			int i=0;
			String [] vLine = new String[] {"a", "b","c","d","e","f","g","h","i"};

			while(true){
				if (vLine[i].equals(v)){
					int vpix=i*px_sq;
					return vpix;
					} 
				i++;
			}
		}
		
		static int hPix(String h){
			int px_sq = 64;
			int i = 0;
			String [] hLine = new String[] {"1", "2","3","4","5","6","7","8","9"};
			
			while(true) {
				if (hLine[i].equals(h)){
					int hpix=i*px_sq;
					return hpix;
					}
				i++;
			}
		}
}
