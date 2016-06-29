package datastructure.sort;


/**
 * 
	����	���ʱ����� 	ƽ��ʱ�临�Ӷ� 	�ȶ��� 	�ռ临�Ӷ�
	ð������ 	O(n2) 		O(n2) 		�ȶ� 		O(1)
	�������� 	O(n2) 		O(n*log2n) 	���ȶ� 	O(log2n)~O(n)
	ѡ������ 	O(n2) 		O(n2) 		�ȶ� 		O(1)
	���������� 	O(n2) 		O(n*log2n) 	��һ�� 	O(n)
	��������	O(n2) 		O(n2) 		�ȶ� 		O(1)
	������ 	O(n*log2n) 	O(n*log2n) 	���ȶ� 	O(1)
	ϣ������ 	O 			O 			���ȶ� 	O(1)
 *
 */
public class Demo {
	public static void main(String[] args) {
		//ѡ������
//		SelectSort selectSort = new SelectSort();
//		int[] data = new int[]{7,5,2,1,6,8};
//		int[] sortResult = selectSort.sort(data);
//		for (int i : sortResult) {
//			System.out.println(i);
//		}
		
		//ð������
//		BubbleSort bubbleSort = new BubbleSort();
//		int[] data = new int[]{7,5,2,1,6,8};
//		bubbleSort.sort(data);
//		for (int i : data) {
//			System.out.println(i);
//		}
		
		//��������
//		QuickSort quickSort = new QuickSort();
//		Integer[] data = new Integer[]{7,5,2,1,6,8};
//		quickSort.sort(data);
//		for (int i : data) {
//			System.out.println(i);
//		}
		
		//��������
		InsertSort insertSort = new InsertSort();
		int[] data = new int[]{7,5,2,1,6,8};
		insertSort.sort(data);
		for (int i : data) {
			System.out.println(i);
		}
	}
}
