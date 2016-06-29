package datastructure.sort;

public class InsertSort {
	public void sort(int[] data){
		for (int i = 1; i < data.length; i++) {
			for (int j = i; j > 0 && less(data[j],data[j-1]); j--) {
				swap(data, j, j-1);
			}
		}
	}
	private boolean less(Integer a,Integer b){
		return a.compareTo(b)<0;
	}
	
	private void swap(int[] data,int a,int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
}
