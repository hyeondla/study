
public class Test {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=5; j++) {
				System.out.printf("i : %d, j : %d\n", i, j);
			}
			System.out.println("---------------");
		}
		
		System.out.println("========================");
		
		for(int min=0; min<60; min++) {
			for(int sec=0; sec<60; sec++) {
				System.out.printf("%d분 %d초\n", min, sec);
			}
		}
		
		System.out.println("========================");
		
		for(int i=2; i<=9; i++) {
			System.out.printf("< %d단 >\n", i);
			for(int j=1; j<=9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
			System.out.println("--------------");
		}
		
		System.out.println("========================");
		
		for(int dice1=1; dice1<=6; dice1++) {
			for(int dice2=1; dice2<=6; dice2++) {
				if(dice1 + dice2 == 6) {
					System.out.println("주사위1 : " + dice1 + ", 주사위2 : " + dice2);
				}
			}
		}
		
		System.out.println("========================");
		
		for(int x=0; x<=10; x++) {
			for(int y=0; y<=10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%d,%d)\n", x, y);
				}
			}
		}
		
	}

}
