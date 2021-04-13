
public class Ex {

	public static void main(String[] args) {
		
		//중첩 while문
		
		int i = 1;
		while(i <= 5) {
			int j = 1;
			while(j <= 3) {
				System.out.printf("i : %d, j : %d\n", i, j);
				j++;
			}
			i++;
			System.out.println("-------------");
		}
		
		
	}

}
