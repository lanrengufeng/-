package jinjie;

import java.util.Arrays;

import chuji.MyTest;

/**
 * BFPRT算法的实现
 * 
 * @author Watcher
 *
 */
public class BFPRT {

	public static void main(String[] args) {
		int times = 10000, maxSize = 100, maxValue = 100;
		boolean flag = true;
		while (times-- > 0) {
			int[] arr = MyTest.getRandomArray(maxSize, maxValue); // 获得一个长度为maxSize，取值范围0-maxValue的数组
			if (arr.length == 0)
				continue;
			int k = (int) (Math.random() * arr.length) + 1; // k为1-arr.length之间的某个数
			int res = findK(arr, 0, arr.length - 1, k);
			Arrays.sort(arr);
			if (res != arr[k - 1])
				flag = false;
			if (!flag) {
				System.out.println(k);
				System.out.println(Arrays.toString(arr));
				break;
			}
		}
		if (flag)
			System.out.println("Great!");
		else
			System.out.println("fucking fucked!!");
	}

	/**
	 * 获取数组中第k小的数
	 * 
	 * @param arr
	 * @param lo
	 * @param hi
	 * @param k
	 * @return
	 */
	private static int findK(int[] arr, int lo, int hi, int k) {
		if (arr == null || arr.length == 0 || k > arr.length)
			return -1;
		if (lo >= hi)
			return arr[lo];
		int pos = getPos(arr, lo, hi); //获取标志位
		int[] p = partition(arr, lo, hi, k, pos);
		if (p[0] < k && k <= p[1] + 1) // 若目前所排的部分包含第k个数，则返回，否则递归排序左边或右边
			return arr[p[0]];
		else if (k <= p[0])
			return findK(arr, 0, p[0] - 1, k);
		else
			return findK(arr, p[1] + 1, hi, k);
	}

	/**
	 * 获取标志位，用于在partition过程作为参照数
	 * 
	 * @param arr
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int getPos(int[] arr, int lo, int hi) {
		int[] arr5 = new int[(hi - lo) / 5 + 1]; // 存放切割后的多个小数组的中位数
		for (int i = lo; i <= hi; i += 5) {
			int size = hi - i >= 4 ? 5 : hi - i + 1; // 当前小数组的实际长度
			int[] tmp = new int[size];
			for (int j = 0; j < size; j++)
				tmp[j] = arr[i + j];
			Arrays.sort(tmp);
			arr5[(i - lo) / 5] = tmp[(tmp.length - 1) / 2];
		}
		return findK(arr5, 0, arr5.length - 1, (arr5.length + 1) / 2); // 递归求arr5的(下)中位数
	}

	/**
	 * 基于快排的partition过程，小于pos的放左边，等于pos的放中间，大于pos的放右边
	 * 
	 * @param arr
	 * @param lo
	 * @param hi
	 * @param k
	 * @param pos
	 * @return
	 */
	private static int[] partition(int[] arr, int lo, int hi, int k, int pos) {
		int less = lo - 1, more = hi;
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

	/**
	 * 交换两个数
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		if (i != j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}

}
