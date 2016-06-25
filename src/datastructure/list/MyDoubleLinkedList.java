package datastructure.list;

public class MyDoubleLinkedList<T> {
	
	private Node first;
	private Node last;
	private int size;
	
	public class Node{
		T data;
		//指向上一个节点
		Node prev;
		//指向下一个节点
		Node next;
		
		public Node(){
		}
		
		public Node(T data){
			this.data = data;
		}
	} 
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int length(){
		return size;
	}
	
	public Node getNodeByIndex(int index){
		//从头节点开始查找
		if(index <= size/2){
			int i = 0;
			for(Node current = first;i<=size/2 && current!=null;current = current.next,i++){
				if(i == index){
					return current;
				}
			}
		}else{
			//从尾节点开始查找
			int i = 0;
			for(Node current = last;i>=size/2 && current!=null;current = current.prev,i++){
				if(i == index){
					return current;
				}
			}
		}
		return null;
	}
	
	//插入节点
	public void insert(int index,T data){
		//如果是第一个节点
		if(index == 0){
			Node oldFirst = first;
			first = new Node(data);
			first.next = oldFirst;
		}else{
			//获取前一个节点
			Node prevNode = getNodeByIndex(index-1);
			//获取插入节点
			Node nextNode = prevNode.next;
			Node newNode = new Node(data);
			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = nextNode;
			if(nextNode!=null){
				nextNode.prev = newNode;
			}
		}
		size++;
	}
	
	//尾插法
	public void add(T data){
		Node oldLast = last;
		last = new Node();
		last.data = data;
		last.prev = oldLast;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		size++;
	}
	//头插法
	public void addAtFirst(T data){
		Node oldFirst = first;
		first = new Node(data);
		first.next = oldFirst;
		oldFirst.prev = first;
	}
	
	public void display(){
		for(Node current = first;current!=null;current = current.next){
			System.out.println(current.data);
		}
	}
	
}
