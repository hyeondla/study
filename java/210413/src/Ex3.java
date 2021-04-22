
public class Ex3 {

	public static void main(String[] args) {

		//break문
		
		int i;
		
		for(i=1; i<=10; i++) {
			System.out.println(i);
	
			if(i == 5) {
				System.out.println("i = 5 -> for문 종료");
				break;
			}
			
		}
		System.out.println("for문 종료 후 i값 : " + i);
		
		System.out.println("-----------------------");
		
		i = 1;
		while(i<=10) {
			System.out.println(i);
			
			if(i == 5) {
				System.out.println("i = 5 -> while문 종료");
				break;
			}
			
			i++;
		}
		System.out.println("while문 종료 후 i값 : " + i);
		
		System.out.println("==========================");
		
		//continue문
		
		for(i=1; i<=10; i++) {
	
			if(i == 5) {
				System.out.println("i = 5 -> 출력문 실행 생략");
				continue;
			}
			System.out.println(i);
			
		}
		
		
		
		
	}

}
