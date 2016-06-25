package datastructure.queue;

public class MyArrayListQueue<T> {
	private Object[] array;
	//指向头部
	private int first = 0;
	//指向尾部
	private int last = 0;
	//长度
	private int size;
	
	public MyArrayListQueue(){
		array = new Object[50];
	}
	
	public boolean isEmpty(){
		return size<=0;
	}
	
	public int length(){
		return size;
	}
	
	//入队
	public void enqueue(T data){
		array[last++] = data;
		size++;
	}
	
	//出队
	public T dequeue(){
		T data = (T) array[first++];
		size--;
		return data;
	}
	
	//移除队尾元素
	public T remove(){
		T data = (T) array[last-1];
		array[last] = null;
		size--;
		last--;
		return data;
	}
	
	public void dispaly(){
		for (int i = first; i < last; i++) {
			System.out.println(array[i]);
		}
	}
	
}
