package datastructure.list;


public class Demo {
	public static void main(String[] args) {
//		MyArrayList<Integer> list = new MyArrayList<Integer>();
//		list.add(2);
//		list.add(2);
//		list.insert(2, 3);
//		System.out.println(list.get(2));
//		System.out.println(list.length());
//		System.out.println(list.toString());
		
//		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
//		linkedList.add(1);
//		linkedList.add(2);
//		linkedList.add(3);
//		linkedList.add(4);
//		linkedList.add(5);
//		linkedList.add(6);
//		linkedList.add(7);
//		System.out.println(linkedList.max(linkedList.getFirstNode()));
//		for (Integer integer : linkedList) {
//			System.out.println(integer);
//		}
		
		MyDoubleLinkedList<String> doubleLinkedList = new MyDoubleLinkedList<String>();
		doubleLinkedList.add("����");
		doubleLinkedList.add("����");
		doubleLinkedList.add("����");
		doubleLinkedList.add("����");
		doubleLinkedList.add("����1");
		doubleLinkedList.add("����2");
		doubleLinkedList.addAtFirst("��");
		doubleLinkedList.display();
	}
}
