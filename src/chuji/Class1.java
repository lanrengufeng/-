package chuji;

/**
 * 第一节课
 * 
 * @author kafka
 *
 */
public class Class1 {

	/**
	 * bubble sort
	 * 
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// 交换i和j对应的值
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];

	}

	/**
	 * insertSort
	 * 
	 * @param arr
	 */
	public static void insertSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j >= 1 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
		}
	}

	/**
	 * mergeSort
	 * 
	 * @param arr
	 */
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start == end)
			return;
		int mid = start + ((end - start) >> 1);
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int[] help = new int[end - start + 1]; // 辅助数组
		int i = 0;
		int p1 = start;
		int p2 = mid + 1;
		while (p1 <= mid && p2 <= end)
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		while (p1 <= mid)
			help[i++] = arr[p1++];
		while (p2 <= end)
			help[i++] = arr[p2++];
		for (i = 0; i < help.length; i++)
			arr[start + i] = help[i];

	}

	/**
	 * 数组小数和：在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。 借助归并排序思路求解
	 * 
	 * @param arr
	 * @return
	 */
	public static int smallSum(int[] arr) {
		int sum = 0;

		return sum;
	}

	public static void main(String[] args) {
		int testTime = 10000; // 测试次数
		int maxSize = 100; // 数组最大长度
		int maxValue = 100; // 数组数值的最大绝对值
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyTest.getRandomArray(maxSize, maxValue);// 随机生成数组
			int[] arr2 = MyTest.copyArray(arr1); // 复制数组

			// 要测试的排序方法
			mergeSort(arr1);
			MyTest.comparator(arr2);
			// 一旦有一次排序出错就结束循环
			if (!MyTest.isEqual(arr1, arr2)) {
				succeed = false;
				MyTest.printArray(arr2);
				MyTest.printArray(arr1);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = MyTest.getRandomArray(maxSize, maxValue);
		System.out.println("排序前： ");
		MyTest.printArray(arr);
		// 要测试的排序方法
		mergeSort(arr);
		System.out.println("排序后： ");
		MyTest.printArray(arr);
	}

}
