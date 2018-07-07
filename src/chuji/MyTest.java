package chuji;

import java.util.Arrays;

/**
 * 对数器 对数器的概念和使用 0，有一个你想要测的方法a， 1，实现一个绝对正确但是复杂度不好的方法b， 2，实现一个随机样本产生器 3，实现比对的方法
 * 4，把方法a和方法b比对很多次来验证方法a是否正确。 5，如果有一个样本使得比对出错，打印样本分析是哪个方法出错
 * 6，当样本数量很多时比对测试依然正确，可以确定方法a已经正确。
 * 
 * @author kafka
 *
 */
public class MyTest {

	/**
	 * 一个绝对正确的排序方法，调用系统的Arrays.sort()
	 * 
	 * @param arr
	 */
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	/**
	 * 随机生成一个数组，从0到maxValue最大长度为maxSize
	 * 
	 * @param maxSize
	 * @param maxValue
	 * @return
	 */
	public static int[] getRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	/**
	 * 复制arr到一个新的数组
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] copyArray(int[] arr) {
		if (arr == null)
			return null;
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	/**
	 * 判断两个数组的内容是否相等
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
			return false;
		if (arr1 == null && arr2 == null)
			return true;
		if (arr1.length != arr2.length)
			return false;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	/**
	 * 打印数组
	 * 
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		if (arr == null)
			return;
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
