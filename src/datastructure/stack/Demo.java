package datastructure.stack;

import java.util.Iterator;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>(5);
		MyLinkedListStack<String> linkedStack = new MyLinkedListStack<String>();
		Scanner s = new Scanner(System.in);
		String str = null;
		while (!(str=s.nextLine()).equals("-")) {			
//			stack.push(str);
			linkedStack.push(str);
		}
		

		
		System.out.println("����:"+linkedStack.length());
				
		//����Stack����
//		Iterator<String> i = stack.iterator();
//		while (i.hasNext()) {
//			System.out.println(i.next());
//		}
		
		//����Stack����
		Iterator<String> i = linkedStack.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
