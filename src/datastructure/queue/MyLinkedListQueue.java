package datastructure.queue;

import java.util.Iterator;

public class MyLinkedListQueue<T> implements Iterable<T>{
	//指向第一个添加的节点
	private Node first;
	//指向最近添加的节点
	private Node last;
	//队列长度
	private int size;
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int length(){
		return size;
	}
	
	public class Node{
		T data;
		Node next;
	}
	
	public void enqueue(T data){
		//从队尾添加数据
		Node oldlast = last;
		last = new Node();
		last.data = data;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldlast.next = last;
		}
		size++;
	}
	
	public T dequeue(){
		T data = first.data;
		first = first.next;
		size--;
		return data;	
	}

	@Override
	public Iterator<T> iterator() {
		// TODO 自动生成的方法存根
		return new iterable();
	}
	public class iterable implements Iterator<T>{
		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO 自动生成的方法存根
			return current!=null;
		}

		@Override
		public T next() {
			T data = current.data;
			current = current.next;
			return data;
		}

		@Override
		public void remove() {
			// TODO 自动生成的方法存根
			
		}

	}
}
