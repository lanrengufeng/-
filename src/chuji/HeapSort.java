package chuji;

import java.security.AllPermission;

/**
 * 堆排序
 * 
 * @author kafka
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int testTime = 10000;
		int maxSize = 100;
		int maxValue = 100;
		boolean res = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = MyTest.getRandomArray(maxSize, maxValue);
			int[] arr2 = MyTest.copyArray(arr1);
			MyTest.comparator(arr1);
			heapSort(arr2);
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
		heapSort(arr);
		System.out.println("排序后： ");
		MyTest.printArray(arr);
	}

	/**
	 * 堆排序
	 * 
	 * @param arr
	 */
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		// 建堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}

	}

	/**
	 * 堆化
	 * 
	 * @param arr
	 * @param i
	 * @param size
	 */
	private static void heapify(int[] arr, int index, int size) {
		// 堆化过程
		int left = 2 * index + 1;
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index)
				break;
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}

	}

	/**
	 * 建立大根堆
	 * 
	 * @param arr
	 * @param i
	 */
	private static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}

	}

	/**
	 * 交换数组中的两个数
	 * 
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
