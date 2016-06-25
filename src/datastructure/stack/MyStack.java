package datastructure.stack;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T>{
	//底层数组
	private Object[] array;
	//栈长度
	private int size;
	
	public MyStack(){
		array = new Object[50];
	}
	
	public MyStack(int length){
		array = new Object[length];
	}
	
	public void push(T data){
		resize();
		array[size++] = data;
	}
	
	public T pop(){
		return (T) array[--size];
	}
	
	//保证底层数组长度充足
	public void resize(){
		if(size==array.length){
			Object[] temp = new Object[2*array.length];
			for (int i = 0; i < size; i++) {
				temp[i] = array[i];
			}
			array = temp;
			temp = null;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iteration();
	}
	
	public class Iteration implements Iterator<T>{
		
		@Override
		public boolean hasNext() {
			// TODO 自动生成的方法存根
			return size>0;
		}

		@Override
		public T next() {
			// TODO 自动生成的方法存根
			return (T) array[--size];
		}

		@Override
		public void remove() {
			// TODO 自动生成的方法存根
		}
		
	}

}
