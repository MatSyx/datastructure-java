package datastructure.queue;

public class MyArrayListQueue<T> {
	private Object[] array;
	//ָ��ͷ��
	private int first = 0;
	//ָ��β��
	private int last = 0;
	//����
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
	
	//���
	public void enqueue(T data){
		array[last++] = data;
		size++;
	}
	
	//����
	public T dequeue(){
		T data = (T) array[first++];
		size--;
		return data;
	}
	
	//�Ƴ���βԪ��
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
