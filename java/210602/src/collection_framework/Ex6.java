package collection_framework;

import java.util.LinkedList;
import java.util.Queue;

public class Ex6 {

	public static void main(String[] args) {
		
		// Queue (인터페이스 -> List)
		Queue<String> q = new LinkedList<String>();
		
		// offer()
		q.offer("1 - Ex.java");
		q.offer("2 - index.jsp");
		q.offer("3 - ReadMe.txt");
		System.out.println(q);
		
		// peek()
		System.out.println(q.peek());
		System.out.println(q.peek());
		
		// poll()
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll()); // null 리턴
		
	}

}
