package org.edie.alg.merge;

public class MergeSort {
	private static int[] data = { 51, 38, 49, 27, 62, 05, 16 };

	public static void main(String args[]) {
		printArray(data);
		sort(data, 0, data.length - 1);
	}

	public static void sort(int[] data, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(data, low, mid);
			sort(data, mid + 1, high);
			merge(data, low, mid, high);
		}
	}

	private static void merge(int[] data, int low, int mid, int high) {
		int i = low;
		int p = low;// 遍历第一个序列
		int q = mid + 1;// 遍历第二个序列

		int tmp[] = new int[data.length];// 保存排序后的数组

		while (p <= mid && q <= high) {
			if (data[p] < data[q]) {
				tmp[i++] = data[p++];
			} else {
				tmp[i++] = data[q++];
			}
		}

		// 添加剩余的值
		while (p <= mid) {
			tmp[i++] = data[p++];
		}

		while (q <= high) {
			tmp[i++] = data[q++];
		}
		// 复制排序后的数组到初始数组
		for (int j = low; j <= high; j++) {
			data[j] = tmp[j];
		}
	}

	private static void printArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

}
