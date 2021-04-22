
public class Dan {

	public static void main(String[] args) {
		
		for(int k=2; k<10; k++) {
			System.out.printf(" <%d단>        ", k);
		}
		System.out.println();
		
		for(int i=1; i<10; i++) {
			for(int j=2; j<10; j++) {
				System.out.printf("%2d * %2d = %2d |", j, i, j * i);
			}
			System.out.println();
		}
		
	}

}
