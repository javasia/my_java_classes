package lesson3.checkpoint_1;

public class Frame_3_1_12 {

	public static void main(String[] args) {

		int[] data1 = {};
		int[] data2 = {1,2,3,4,5};
		int[] data3 = {-1,0,3};
		int[] data4 = {12112,3,4,5,6,7,8};
		int[] data5 = {1};
		
		printArray(data1);
		printArray(data2);
		printArray(data3);
		printArray(data4);
		printArray(data5);
		
	}
static void printArray(int[] data){
	
	System.out.print("[");
	int n = 0;
	String varcoma=",";
	
	while (n <= data.length - 1) {
		if (data.length-1==n){
			varcoma="";
		}
		System.out.print(data[n++] + varcoma);
	}
	System.out.print("]\n");

	
}
	
}
