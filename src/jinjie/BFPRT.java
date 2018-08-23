package jinjie;

import java.util.Arrays;

/**
 * BFPRT算法的实现
 * 
 * @author Watcher
 *
 */
public class BFPRT {

	public static void main(String[] args) {

	}

	private static int findK(int[] arr,int lo,int hi, int k) {
		if(arr==null||arr.length==0)
			return -1;
		if(lo>=hi)
			return arr[lo];
		return 0;
	}

	private static int getPos(int[] arr, int lo, int hi) {
		if (hi - lo < 5) {
			Arrays.sort(arr, lo, hi + 1);
			return arr[lo + (hi - lo) / 2];
		}
		int[][] arrs = new int[(hi - lo) / 5][];
		for (int i = 0; i <= hi - lo; i++)
			arrs[i / 5][i % 5] = arr[lo + i];
		for (int i = 0; i < arrs.length; i++)
			Arrays.sort(arrs[i]);
		int[] arr5 = new int[arrs.length];
		int pos = getPos(arr5, 0,arr5.length-1);
		return pos;
	}

	private static int[] partition(int[] arr, int lo, int hi, int k, int pos) {
		int less = -1, more = hi;
		while (lo <= more) {
			if (arr[lo] < pos)
				swap(arr, ++less, lo++);
			else if (arr[lo] > pos)
				swap(arr, more--, lo);
			else
				lo++;
		}
		return new int[] { less + 1, more };
	}

	private static void swap(int[] arr, int i, int j) {
		if (i != j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}

}
