
public class Test {

	public static void main(String[] args) {

		for(int i=1; i<10; i++) {
			System.out.println(i);
		}
		
		System.out.println("==========================");
		
		int dan = 8;
		
		System.out.printf("< %d단 >\n", dan);
		for(int i=1; i<10; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
		
		
	}

}
