package org.edie.alg.insert;

/*
 * 折半二分排序
 * 当直接插入排序进行到某一趟时，对于 r[i].key 来讲，前边 i-1 个记录已经按关键字有序。
 * 此时不用直接插入排序的方法，而改为折半查找，找出 r[i].key 应插的位置，然后插入。
 * 这种方法就是折半插入排序（ Binary insertion sort ）。

 */
public class BinaryInsertionSort {
	public void sort(int[] array) {
		if (array == null) {
			return;
		}
		
		for(int i=1;i<array.length;i++){
			if(array[i] < array[i-1]){
				int tmp = array[i];
				int low  = 0;
				int high = i-1;
				
				while(low<=high){
					int mid = (low+high)/2;
					if(tmp > array[mid]){
						low = mid +1;
					}else{
						high = mid-1;
					}
				}
				
				//将low~i处数据整体向后移动1位 
				for(int j=i;j>low;j--){
					array[j] = array[j--];
				}
				
				
				array[low] = tmp;
				
			}
		}
	}

}
