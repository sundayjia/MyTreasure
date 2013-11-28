package org.edie.alg.exchange;

/*
 *
 冒泡排序的基本概念是依次比较相邻的两个元数，将小的数放在前面，大的数放在后面。
 即在第一趟排序中，首先比较第1个数和第2个数，将小数放前，大数放后；
 然后比较第2个数和第3个数，将小数放前，大数放后。以此类推，如此继续，直到比较最后两个数，将小数放前，大数放后。至此，第一趟排序结束，将最大的数放到了最后！
 第二趟：仍从第一对数开始比较，将小数放前，大数放后，一直比到倒数第2个数（倒数第1个数已经是最大的了），第二趟结束，倒数第2的位置上得到一个新的最大数。
 以此类推，重复以上过程，直至最终完成排序。
 */
public class BubbleSort {

	public static void sort(int[] array) {
		int len = array.length;
		// 最多做n-1趟排序
		for (int i = 0; i < len - 1; i++) {
			// 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
			for (int j = 0; j < len - i - 1; j++) {
				if (array[j] > array[j + 1]) {// 把大的值交换到后面
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int array[] = { 67, 69, 75, 87, 89, 90, 99, 100 };
		sort(array);
	}

	private static void print(int[] array) {
		for (int a = 0; a < array.length; a++) {
			System.out.print(array[a] + "\t");
		}
	}

}
