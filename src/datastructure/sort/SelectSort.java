package datastructure.sort;

public class SelectSort {
	public int[] sort(int[] data){
		for (int i = 0; i < data.length-1; i++) {
			for (int j = i+1; j < data.length; j++) {
				if(data[i]>data[j]){
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		return data;
	}
}
