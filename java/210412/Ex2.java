
public class Ex2 {

	public static void main(String[] args) {
		
		//while문
		
		for(int i=0; i<10; i++) {
			System.out.println("Hello, World!");
		}
		
		System.out.println("-----------------");
		
		int i = 0; 		
		while(i < 10) {
			System.out.println("Hello, World!");
			i++;
		}
		
		System.out.println("while문 종료 후 i값 : " + i);
		
		System.out.println("-----------------");
		
		i = 1;
		while(i <= 10) {
			System.out.printf("%d ",i);
			i++;
		}
		System.out.println();
		
		i = 1;
		while(i <= 10) {
			System.out.printf("%d ", i);
			i += 2;
		}
		System.out.println();
		
		i =  2;
		while(i <= 10) {
			System.out.printf("%d ", i);
			i += 2;
		}
		System.out.println();
		
		i = 10;
		while(i >= 1) {
			System.out.printf("%d ", i);
			i--;
		}
		System.out.println();
		
		
	}

}
