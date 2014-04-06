package org.edie.alg.exchange;

/*
 *
 冒泡排序的基本概念是依次比较相邻的两个元数，将小的数放在上面，大的数放在下面。最下面的下标是0
 即在第一趟排序中，首先比较第n个数和第n-1个数，将小数放前，大数放后，第一趟排序结束，将最小的数放到了最前面！
 以此类推，重复以上过程，直至最终完成排序。
 第i趟排序后，第i个最小的关键字到达了最终位置，其他关键字也移动到了最接近最终位置的地方。
 */
public class BubbleSort {
	public static void sort1(Comparable []array) {
		int len = array.length;
		// 最多做n-1趟排序
		for (int i = 0; i < len - 1; i++) {
			for (int j = len-1; j <=i; j--) {//从后向前循环
				if (array[j].compareTo(array[j + 1]) < 0) {// 把小的值交换到上面
					swap(array,j, j + 1);
				}
			}
		}
	}

	public static void sort2(Comparable []array) {
		int len = array.length;
		boolean flag = true;// 如果数组中部分有序，则有序的部分就不用再比较了
		// 最多做n-1趟排序
		for (int i = 0; i < len - 1 && flag; i++) {
			flag = false;
			for (int j = len-1; j <=i; j--) {//从后向前循环
				if (array[j].compareTo(array[j + 1]) < 0) {// 把小的值交换到上面
					swap(array,j, j + 1);
					flag = true;
				}
			}
		}
		

	}

	private static void print(Comparable [] array) {
		for (int a = 0; a < array.length; a++) {
			System.out.print(array[a] + "\t");
		}
	}

	private static void swap(Comparable [] array, int l, int r) {
		Comparable temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}
	public static void main(String[] args) {
		Comparable[] array = { 67, 69, 75, 87, 89, 90, 99, 100 };
		sort2(array);
		print(array);
	}

}
