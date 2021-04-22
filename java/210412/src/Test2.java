
public class Test2 {

	public static void main(String[] args) {
		
		int i = 1, dan = 2;
		System.out.println("< " + dan + "단 >");
		while(i <= 9) {
			System.out.printf("%d * %d = %d\n", dan, i, 2*i);
			i++;
		}
		
		System.out.println("=================================");
		
		i = 1;
		int total = 0;
		
		while(i <= 10) {
			total += i++;
//			i++;
		}
		System.out.println(total);
		
	}

}
