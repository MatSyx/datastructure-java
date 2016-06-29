package datastructure.sort;

public class QuickSort{
	
	public void sort(Integer[] data,int low,int high){
		if(low<high){
			int base = data[low];
			int i = low;
			int j = high+1;
			while (true) {
				while (i<high && data[++i].compareTo(base)<=0);
				while (j>low && data[--j].compareTo(base)>=0);
				if(i<j){
					swap(data, i, j);
				}else{
					break;
				}
			}
			//ÉèÖÃ·Ö½çÖµ
			swap(data,low,j);
			//µÝ¹é×ó
			sort(data,low,j-1);
			//µÝ¹éÓÒ
			sort(data,j+1,high);
		}
	}
	
	public void sort(Integer[] data){
		sort(data, 0, data.length-1);
	}
	
	public void swap(Integer[] data,int i,int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
}
