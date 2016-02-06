package lesson3.checkpoint_5;

import java.util.Arrays;

public class Frame_3_5_3 {

	static boolean checkflag = false;

	public static void main(String[] args) {

		int[] src = { 0, 1, 2, 3, 4, 5 };
		int srcPos = 2;
		int destPos = 2;
		int length = 4;
		int[] dest = new int[7];

		copyArray(src, srcPos, dest, destPos, length);
		if (checkflag == true) {
			dest = null;
		}
		System.out.println(Arrays.toString(dest));

		srcPos = 100;
		destPos = 0;
		length = 3;

		copyArray(src, srcPos, dest, destPos, length);
		if (checkflag == true) {
			dest = null;
		}
		System.out.println(Arrays.toString(dest));

		srcPos = 0;
		destPos = 100;
		length = 3;

		copyArray(src, srcPos, dest, destPos, length);
		if (checkflag == true) {
			dest = null;
		}
		System.out.println(Arrays.toString(dest));

		srcPos = 0;
		destPos = 0;
		length = 100;

		copyArray(src, srcPos, dest, destPos, length);
		if (checkflag == true) {
			dest = null;
		}
		System.out.println(Arrays.toString(dest));

		srcPos = 0;
		destPos = 0;
		length = 3;

		copyArray(null, srcPos, dest, destPos, length);
		if (checkflag == true) {
			dest = null;
		}
		System.out.println(Arrays.toString(dest));

		srcPos = 0;
		destPos = 0;
		length = 3;

		copyArray(src, srcPos, null, destPos, length);
		if (checkflag == true) {
			dest = null;
		}
		System.out.println(Arrays.toString(dest));

	}

	static void copyArray(int[] src, int srcPos, int[] dest, int destPos, int length) {

		if (src != null && dest != null && srcPos >= 0 && destPos >= 0 && src.length >= (srcPos + length)
				&& dest.length >= (destPos + length)) {
			for (int i = 0; i < length; i++) {
				dest[destPos + i] = src[i + srcPos];
			}
		} else {
			checkflag = true;
			System.out.println("Illegal parameters!");
		}

	}

}