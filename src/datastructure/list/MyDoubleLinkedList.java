package datastructure.list;

public class MyDoubleLinkedList<T> {
	
	private Node first;
	private Node last;
	private int size;
	
	public class Node{
		T data;
		//ָ����һ���ڵ�
		Node prev;
		//ָ����һ���ڵ�
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
		//��ͷ�ڵ㿪ʼ����
		if(index <= size/2){
			int i = 0;
			for(Node current = first;i<=size/2 && current!=null;current = current.next,i++){
				if(i == index){
					return current;
				}
			}
		}else{
			//��β�ڵ㿪ʼ����
			int i = 0;
			for(Node current = last;i>=size/2 && current!=null;current = current.prev,i++){
				if(i == index){
					return current;
				}
			}
		}
		return null;
	}
	
	//����ڵ�
	public void insert(int index,T data){
		//����ǵ�һ���ڵ�
		if(index == 0){
			Node oldFirst = first;
			first = new Node(data);
			first.next = oldFirst;
		}else{
			//��ȡǰһ���ڵ�
			Node prevNode = getNodeByIndex(index-1);
			//��ȡ����ڵ�
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
	
	//β�巨
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
	//ͷ�巨
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
