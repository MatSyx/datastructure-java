package datastructure.sort;


/**
 * 
	排序法	最差时间分析 	平均时间复杂度 	稳定度 	空间复杂度
	冒泡排序 	O(n2) 		O(n2) 		稳定 		O(1)
	快速排序 	O(n2) 		O(n*log2n) 	不稳定 	O(log2n)~O(n)
	选择排序 	O(n2) 		O(n2) 		稳定 		O(1)
	二叉树排序 	O(n2) 		O(n*log2n) 	不一顶 	O(n)
	插入排序	O(n2) 		O(n2) 		稳定 		O(1)
	堆排序 	O(n*log2n) 	O(n*log2n) 	不稳定 	O(1)
	希尔排序 	O 			O 			不稳定 	O(1)
 *
 */
public class Demo {
	public static void main(String[] args) {
		//选择排序
//		SelectSort selectSort = new SelectSort();
//		int[] data = new int[]{7,5,2,1,6,8};
//		int[] sortResult = selectSort.sort(data);
//		for (int i : sortResult) {
//			System.out.println(i);
//		}
		
		//冒泡排序
//		BubbleSort bubbleSort = new BubbleSort();
//		int[] data = new int[]{7,5,2,1,6,8};
//		bubbleSort.sort(data);
//		for (int i : data) {
//			System.out.println(i);
//		}
		
		//快速排序
//		QuickSort quickSort = new QuickSort();
//		Integer[] data = new Integer[]{7,5,2,1,6,8};
//		quickSort.sort(data);
//		for (int i : data) {
//			System.out.println(i);
//		}
		
		//插入排序
		InsertSort insertSort = new InsertSort();
		int[] data = new int[]{7,5,2,1,6,8};
		insertSort.sort(data);
		for (int i : data) {
			System.out.println(i);
		}
	}
}
