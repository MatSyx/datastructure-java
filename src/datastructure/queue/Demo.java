package datastructure.queue;

import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
//		MyLinkedListQueue<String> queue = new MyLinkedListQueue<String>();
//		queue.enqueue("1");
//		queue.enqueue("2");
//		queue.enqueue("3");
//		queue.enqueue("4");
//		queue.enqueue("4");
//		queue.enqueue("4");
//		queue.enqueue("4");
//		
//		Iterator i = queue.iterator();
//		while (i.hasNext()) {
//			System.out.println(i.next());
//		}
		
//		MyArrayListQueue<String> arrayListQueue = new MyArrayListQueue<String>();
//		arrayListQueue.enqueue("����");
//		arrayListQueue.enqueue("����");
//		arrayListQueue.enqueue("����");
//		arrayListQueue.remove();
//		arrayListQueue.dispaly();
//		System.out.println(arrayListQueue.length());
//		System.out.println(arrayListQueue.isEmpty());
		
		MyDeque<String> deque = new MyDeque<String>();
		deque.pushLeft("1");
		deque.pushRight("����");
		deque.pushRight("����");
		deque.pushRight("����");
		deque.pushRight("����");
		deque.pushLeft("2");
		deque.pushLeft("3");
		deque.pushRight("Ǯ��");
		deque.dispaly();
	}
}
