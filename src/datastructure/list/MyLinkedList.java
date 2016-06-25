package datastructure.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
	
	private Node last;
	private Node first;
	private int size;
	static int max = 0;
	public class Node{
		T data;
		Node next;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insert(int index,T data){
		if(index == 0){
			Node oldfirst = first;
			first = new Node();
			first.data = data;
			first.next = oldfirst;
		}else{
			Node newNode = new Node();
			Node prevNode = getNodeByIndex(index-1);
			Node nextNode = prevNode.next;
			newNode.data = data;
			prevNode.next = newNode;
			newNode.next = nextNode;
		}
		size++;
	}
	
	public void add(T data){
		Node oldLast = last;
		last = new Node();
		last.data = data;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		size++;
//		insert(size, data);
	}
	
	//删除链表第K个元素
	public T delete(int k){
		Node del = null;
		//如果删除的是第一个节点
		if(k==0){
			del = first;
			first = first.next;
		}else{
			//获取前一个节点
			Node perv = getNodeByIndex(k-1);
			del = perv.next;
			perv.next = del.next;
			del.next = null;
		}
		size--;
		return del.data;
	}
	
	//删除最后一个元素
	public T delete(){
		return delete(size-1);
	}
	
	public Node getNodeByIndex(int index){
		int i = 0;
		for (Node current = first; current!=null; current=current.next,i++) {
			if(i == index){
				return current;
			}
		}
		return null;
	}
	
	public boolean find(String key){
		for (Node current = first; current!=null; current=current.next) {
			if(current.data == key){
				return true;
			}
		}
		return false;
	}
	
	public void remove(T key){
		int i = 0;
		for (Node current = first; current!=null; current=current.next,i++) {
			if(current.data.equals(key)){
				delete(i);
			}
		}
	}
	
	public int max(Node node){
//		int max = 0;
//		for (Node current = first; current!=null; current=current.next) {
//			if((Integer)current.data > max){
//				max = (Integer)current.data;
//			}
//		}
//		return max;
		
		//递归方式
		if(node.next==null){
			return max;
		}else{
			if((int)node.data > max){
				max = (Integer)node.data;
			}
			return max(node.next);
		}
		
	}
	
	public Node getFirstNode(){
		return first;
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
