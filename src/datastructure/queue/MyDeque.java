package datastructure.queue;

public class MyDeque<T> {
	
	private Node first;
	private Node last;
	private int size;
	
	public class Node{
		T data;
		Node next;
	}
	
	public boolean isEmpty(){
		return size<=0;
	}
	
	public void pushLeft(T data){
		Node oldFirst = first;
		first = new Node();
		first.data = data;
		if(isEmpty()){
			last = first;
		}else{
			first.next = oldFirst;
		}
		size++;
	}
	
	public void pushRight(T data){
		Node oldLast = last;
		last = new Node();
		last.data = data;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		size++;
	}
	
	public T popLeft(){
		T data = first.data;
		first = first.next;
		return data;
	}
	
	public T popRight(){
		T data = last.data;
		last = last.next;
		return data;
	}
	
	public void dispaly(){
		for (Node current = first; current!=null; current = current.next) {
			System.out.println(current.data);
		}
	}
	
}
