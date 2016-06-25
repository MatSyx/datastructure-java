package datastructure.list;

import java.util.Arrays;

public class MyArrayList<T> {
	
	//默认底层数组长度
	private int defaultArraySite = 50;
	
	//底层数组
	private Object[] array;
	
	//线性表长度
	private int site;
	
	public MyArrayList(){
		array = new Object[defaultArraySite];
	}
	
	public MyArrayList(int arratSite){
		array = new Object[arratSite];
	}
	
	public void insert(int index,T data){
		
		//保证底层长度充足
		expand();
		
		if(index > site){
			throw new ArrayIndexOutOfBoundsException("下标越界");
		}
		//向后移动
		for (int i = site; i > index; i--) {
			array[i+1] = array[i];
		}
		array[index] = data;
		site++;
	}
	
	public void add(T data){
		insert(site,data);
	}
	
	public void delete(int index){
		if(index >= site){
			throw new ArrayIndexOutOfBoundsException("下标越界");
		}
		for (int i = index; i <= site; i++) {
			array[i] = array[i+1];
		}
	}
	
	public int length(){
		return site;
	}
	
	//扩充
	public void expand(){
		//获取底层数组长度
		int current = array.length;
		if(site == current-1){
			Object[] newarray = Arrays.copyOf(array, current*2);
			array = newarray;
		}
	}
	
	public T get(int index){
		if(index >= site){
			throw new ArrayIndexOutOfBoundsException("下标越界");
		}
		return (T) array[index];
	}

	@Override
	public String toString() {
		return "MyArrayList [array=" + Arrays.toString(array) + "]";
	}
	
	
}
