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
//		arrayListQueue.enqueue("张三");
//		arrayListQueue.enqueue("李四");
//		arrayListQueue.enqueue("王五");
//		arrayListQueue.remove();
//		arrayListQueue.dispaly();
//		System.out.println(arrayListQueue.length());
//		System.out.println(arrayListQueue.isEmpty());
		
		MyDeque<String> deque = new MyDeque<String>();
		deque.pushLeft("1");
		deque.pushRight("张三");
		deque.pushRight("李四");
		deque.pushRight("王五");
		deque.pushRight("赵六");
		deque.pushLeft("2");
		deque.pushLeft("3");
		deque.pushRight("钱七");
		deque.dispaly();
	}
}
