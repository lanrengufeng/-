package chuji;

/**
 * 第二节
 * 
 * @author kafka
 *
 */
public class Class2 {

	/**
	 * 随机快排，根据荷兰国旗问题改进版，时间复杂度长期期望为O(nlogn)
	 * 
	 * @author kafka
	 *
	 */
	public static class RandomQuickSort {
		public static void main(String[] args) {

			int testTime = 10000;
			int maxSize = 100;
			int maxValue = 100;
			boolean res = true;
			for (int i = 0; i < testTime; i++) {
				int[] arr1 = MyTest.getRandomArray(maxSize, maxValue);
				int[] arr2 = MyTest.copyArray(arr1);
				MyTest.comparator(arr1);
				quickSort(arr2, 0, arr2.length - 1);
				if (!MyTest.isEqual(arr1, arr2)) {
					res = false;
					MyTest.printArray(arr1);
					MyTest.printArray(arr2);
					break;
				}
			}

			System.out.println(res ? "Nice!" : "Fucking fucked!");

			int[] arr = MyTest.getRandomArray(100, 100);
			System.out.println("排序前： ");
			MyTest.printArray(arr);
			// 要测试的排序方法
			quickSort(arr, 0, arr.length - 1);
			System.out.println("排序后： ");
			MyTest.printArray(arr);

		}

		public static void quickSort(int[] arr, int left, int right) {
			if (left >= right)
				return;
			// 随机交换标志位
			swap(arr, right, left + (int) ((right - left + 1) * Math.random()));
			int[] p = partition(arr, left, right);
			quickSort(arr, left, p[0] - 1);
			quickSort(arr, p[1] + 1, right);
		}

		public static int[] partition(int[] arr, int left, int right) {
			int less = left - 1;
			int more = right;
			// 最右边为标志位
			while (left < more) {
				if (arr[left] < arr[right])
					swap(arr, ++less, left++);
				else if (arr[left] > arr[right])
					swap(arr, --more, left);
				else
					left++;
			}
			swap(arr, more, right);
			return new int[] { less + 1, more };
		}
	}

	
	/**
	 * 交换数组中的两个数
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j) {
		if (i == j)
			return;
		// 交换i和j对应的值
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];

	}

}
