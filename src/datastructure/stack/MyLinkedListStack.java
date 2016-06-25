package datastructure.stack;

import java.util.Iterator;

public class MyLinkedListStack<T> implements Iterable<T>{
	
	private Node first = null;
	private int size;
	
	public class Node{
		public T data;
		public Node next;
	}
	
	public void push(T data){
		Node oldFirst = first;
		first = new Node();
		first.data = data;
		first.next = oldFirst;
		size++;
	}
	public T pop(){
		T data = first.data;
		first = first.next;
		size--;
		return data;
	}
	public int length(){
		return size;
	}
	public boolean isEmpty(){
		return first==null;
	}
	@Override
	public Iterator<T> iterator() {
		return new linkedIteration();
	}
	
	public class linkedIteration implements Iterator<T>{
		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
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
