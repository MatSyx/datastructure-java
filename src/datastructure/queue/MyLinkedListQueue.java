package datastructure.queue;

import java.util.Iterator;

public class MyLinkedListQueue<T> implements Iterable<T>{
	//ָ���һ����ӵĽڵ�
	private Node first;
	//ָ�������ӵĽڵ�
	private Node last;
	//���г���
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
		//�Ӷ�β�������
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
		// TODO �Զ����ɵķ������
		return new iterable();
	}
	public class iterable implements Iterator<T>{
		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO �Զ����ɵķ������
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
			// TODO �Զ����ɵķ������
			
		}

	}
}
