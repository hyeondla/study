
public class Test {

	public static void main(String[] args) {

		int min = 0;
		while(min < 60) {
			
			int sec = 0;
			while(sec < 60) {
				System.out.println(min + "분 " + sec + "초");
				sec++;
			}
			
			min++;
		}
		
		System.out.println("========================");
		
		int dan = 2;
		while(dan <= 9) {
			System.out.println(dan + "단");
			int i = 1;
			while(i <= 9) {
				System.out.printf("%d * %d = %d\n", dan, i, dan*i);
				
				i++;
			}
			
			
			dan++;
			System.out.println("----------------");
		}
		

	}

}
