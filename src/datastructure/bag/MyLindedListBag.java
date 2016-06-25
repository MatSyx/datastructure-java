package datastructure.bag;

import java.util.Iterator;

public class MyLindedListBag<T> implements Iterable<T>{
	private int size;
	private Node first;
	private class Node{
		private T data;
		private Node next;
	}
	public void add(T data){
		Node oldfirst = first;
		first = new Node();
		first.data = data;
		first.next = oldfirst;
		size++;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO 自动生成的方法存根
		return new LinkedIterator();
	}
	
	private class LinkedIterator implements Iterator<T>{
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
