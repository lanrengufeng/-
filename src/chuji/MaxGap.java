package chuji;

import java.util.Arrays;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 * 
 * @author kafka
 *
 */
public class MaxGap {

	public static void main(String[] args) {
		int testTime = 10000;
		int maxSize = 100;
		int maxValue = 100;
		boolean res = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyTest.getRandomArray(maxSize, maxValue);
			int[] arr2 = MyTest.copyArray(arr1);
			if (comparator(arr1)!=maxGap(arr2)) {
				res = false;
				MyTest.printArray(arr1);
				System.out.println(comparator(arr1));
				System.out.println(maxGap(arr2));
				break;
			}
		}
 
		System.out.println(res ? "Nice!" : "Fucking fucked!");

		int[] arr = MyTest.getRandomArray(100, 100);
		System.out.println("排序后： ");
		Arrays.sort(arr);
		MyTest.printArray(arr);
		System.out.println("最大差值为： "+maxGap(arr));
	}

	private static int comparator(int[] arr1) {
		if(arr1==null||arr1.length<2)
			return 0;
		int max = 0;
		Arrays.sort(arr1);
		for(int i=1;i<arr1.length;i++)
			max = Math.max(arr1[i]- arr1[i-1],max);
		return max;
	}

	public static int maxGap(int[] arr) {
		if (arr == null || arr.length < 2)
			return 0;
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// 求数组的最大值与最小值
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if (min == max)
			return 0;
		boolean[] hasNum = new boolean[len + 1]; // 这个桶里面是否有数
		int[] mins = new int[len + 1]; // 每一个桶中的最小值
		int[] maxs = new int[len + 1]; // 每一个桶中的最大值
		int bid = 0;	//一个数所在的桶的序号
		for (int i = 0; i < len; i++) {
			bid = bucket(arr[i],len,min,max);
			mins[bid] = hasNum[bid]?Math.min(mins[bid],arr[i]):arr[i];
			maxs[bid] = hasNum[bid]?Math.max(maxs[bid], arr[i]):arr[i];
			hasNum[bid] = true;
		}
		int res = 0;
		int lastMax = maxs[0];		//上一个非空桶中的最大值
		for(int i=1;i<=len;i++){
			if(hasNum[i]){
				res = Math.max(res, mins[i]-lastMax);
				lastMax = maxs[i];
			}
		}

		return res;
	}

	private static int bucket(long num, long len, long min, long max) {
		
		return (int)((num-min)*len/(max-min));
	}
}
