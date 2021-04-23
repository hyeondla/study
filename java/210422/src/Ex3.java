
public class Ex3 {

	public static void main(String[] args) {

		//5. 파라미터 2개 이상
		String snack = "감자깡";
		int myMoney = 1000;
		System.out.println("감자깡 + 1000원 -> 찰떡쿠키로 교환");
		
		snack = exchange(snack, myMoney); //=> 순서
		System.out.println(snack + " 교환!");
		
	}
	
	//5. 파라미터 2개 이상
	public static String exchange(String snack, int money) { //=> 순서
		snack = "찰떡쿠키";
		return snack;
	}
	
}
