package lesson3.checkpoint_2;

import java.util.Arrays;

public class Frame_3_2_11 {

	public static void main(String[] args) {

		//version1
		System.out.println("\nVersion1:");
		swap1(null);
		swap1(new int[0]);
		swap1(new int[]{1});
		swap1(new int[]{1,2,3,4,5,6,7});
		swap1(new int[]{8,9,10,11,12});
		swap1(new int[]{12,8,9,10,11});
		swap1(new int[]{12,8,9,100,11});
		
		
		//version2
		System.out.println("\nVersion2:");
		swap2(null);
		swap2(new int[0]);
		swap2(new int[]{1});
		swap2(new int[]{1,2,3,4,5,6,7});
		swap2(new int[]{8,9,10,11,12});
		swap2(new int[]{12,8,9,10,11});
		swap2(new int[]{12,8,9,100,11});
		
	}

	static void swap1(int[] data){
		
		if (data==null||data.length<2){
			System.out.println("Wrong input data!");
			return;
		}
		for (int i=1;i<data.length;i++){
			int temp=data[i];
			if(data[i-1]>temp){
				data[i]=data[i-1];
				data[i-1]=temp;
				}
		}
		System.out.println(Arrays.toString(data));
	}		
	
	static void swap2(int[] data){
		
		if (data==null||data.length<2){
			System.out.println("Wrong input data!");
			return;
		}
		for (int i=0, j=1;j<data.length;i++,j++){
			int temp=data[j];
			if (temp<data[i]){
			data[j]=data[i];
			data[i]=temp;
			}
		}
		System.out.println(Arrays.toString(data));
	}
}
