package org.edie.alg.insert;
/*
 * 直接插入排序（ straight insertion sort ）是一种最简单的排序方法。
 * 它的基本操作是将一个记录插入到一个长度为 m （假设）的有序表中，使之仍保持有序，从而得到一个新的长度为 m ＋ 1 的有序表。
 */
public class StraightInsertionSort {
	public void sort(int[] array){
		if(array==null){
			return;
		}
		int insTarget;//每次要被插入有序表中的数
		int j;//监视哨，从后向前移动
		for(int i = 1;i<array.length;i++){
			j = i;
			insTarget = array[i];
			while(j>0 && insTarget < array[j-1]){
				array[j] = array[j-1];
				j--;
			}
			array[j] = insTarget;
		}
	}
}
