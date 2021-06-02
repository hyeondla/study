package collection_framework;

import java.util.Stack;

public class Ex5 {

	public static void main(String[] args) {
		
		// Stack
		
		Stack<String> stack = new Stack<String>();
		
		// push()
		stack.push("1 - www.itwillbs.co.kr");
		stack.push("2 - www.naver.com");
		stack.push("3 - www.gmarket.co.kr");
		System.out.println(stack);
		
		// peek() : TOP 요소 확인
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
		// pop() : TOP 요소 확인, 제거
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop()); //오류! EmptyStackException
		
	}

}
