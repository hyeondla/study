
public class Test2 {

	public static void main(String[] args) {
		
		int total = 0, x = 0;
		
		for(int i=1; i<=100; i++) {
			
			total += i;
			
			if(total > 1000) {
//				System.out.println(total);
				x = i;
				break;
			}
			
		}
		
		System.out.println(x);
		
		System.out.println("=========================");
		
		total = 0;
		
		for(int i=1;;i++) {
			
			if(i%2 == 0) {
				total += -i;
			} else {
				total += i;
			}
			
			if(total >= 100) {
//				System.out.println(total);
				x = i;
				break;
			}
			
		}
		
		System.out.println(x);
		
	}

}
