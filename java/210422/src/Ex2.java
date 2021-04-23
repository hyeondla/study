
public class Ex2 {

	public static void main(String[] args) {
		
		//3. 파라미터 O, 리턴값 X
		System.out.println("납부 예정일1");
		
		int myMoney = 5000;
		spendMoney1(myMoney);
		
		System.out.println("---------------------");
		//=========================================== 
		//4. 파라미터 O, 리턴값 O
		
		System.out.println("납부 예정일2");
		
		String result = spendMoney2(50000);
		System.out.println("납부 " + result);
		
	}

	//3. 파라미터 O, 리턴값 X
	public static void spendMoney1(int money) {
		System.out.println("통장에 들어있는 돈 : " + money);
		money -= 2400;
		if(money < 0) {
			return;
			//void 타입에도 return 사용 가능
			//=> 즉시 메서드를 종료하고 돌아감
		}
		System.out.println("교통대금 빠져나가고 " + money + "원 남음");
	}

	
	//4. 파라미터 O, 리턴값 O
	public static String spendMoney2(int money) {
		System.out.println("통장에 들어있는 돈 : " + money);
		money -= 30000;
		System.out.println("통신요금 빠져나가고 " + money + "원 남음");
		
		return "완료";
	}
	
}
