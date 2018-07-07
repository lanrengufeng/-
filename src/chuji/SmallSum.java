package chuji;

import java.util.Arrays;

/**
 * 数组小数和：在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。 借助归并排序思路求解
 * 
 * @author kafka
 *
 */
public class SmallSum {

	public static void main(String[] args) {
		int[] arr = MyTest.getRandomArray(10, 10);
		System.out.println("排序前"+Arrays.toString(arr));
		System.out.println(mergeSort(arr, 0, arr.length-1));
		System.out.println("排序后"+Arrays.toString(arr));
	}

	private static int mergeSort(int[] arr, int left, int right) {
		if(arr==null||arr.length<2)
			return 0;
		if (left == right)
			return 0;
		int mid = left + ((right - left) >> 1);
		return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);
	}

	private static int merge(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];
		int i = 0;
		int p1 = left;
		int p2 = mid + 1;
		int sum = 0;
		while (p1 <= mid && p2 <= right) {
			sum += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid)
			help[i++] = arr[p1++];
		while (p2 <= right)
			help[i++] = arr[p2++];
		for (i = 0; i < help.length; i++)
			arr[left + i] = help[i];

		return sum;
	}
}
