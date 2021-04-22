
public class Ex4 {

	public static void main(String[] args) {

		byte a = 10;
	
		a = (byte)(a + 1); //형변환 필요
		a += 1; //형변환 불필요
		a++; //형변환 불필요
		
		System.out.println(a);
		
		System.out.println("===================");
		
		int b = 5;
		
		b++; //선행연산자
		System.out.println(b);
		++b; //후행연산자
		System.out.println(b);
		b--;
		System.out.println(b);
		--b;
		System.out.println(b);
		
		System.out.println("===================");
		
		int x1 = 5;
		int y1 = ++x1; //x1 값 먼저 증가 후 대입, y = 6
		System.out.println(x1 + ", " + y1);
		
		int x2 = 5;
		int y2 = x2++; // 대입연산자 이후 x2 값 증가, y = 5
		System.out.println(x2 + ", " + y2); 
		
		System.out.println("===================");
		
		x2 = 5;
		System.out.println(++x2); //6
		System.out.println(x2++); //6
		System.out.println(x2); //7
	
		System.out.println("===================");
		
		char ch = 'A';
		System.out.println(ch + 1); //int -> 0660
		System.out.println(ch); //A

		System.out.println(++ch); //B
		System.out.println(ch); //B
		
		
		
		
		
	}

}
