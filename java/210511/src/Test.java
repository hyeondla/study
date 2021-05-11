
public class Test {

	public static void main(String[] args) {

		ItwillBank ib = new ItwillBank();
		
		ib.accountNo = "123-1234-123";
		ib.ownerName = "홍길동";
		ib.balance = 50000;
		ib.showAccountInfo();
		
		ib.deposit(100000);
		ib.withdraw(80000);
		
		System.out.println("--------------------------------");
		
		ib.contract("자동차보험");
	
	}

}

class ItwillBank extends Account {
	
	String insureName;
	
	public void contract(String insureName) {
		this.insureName = insureName;
		System.out.println(insureName + " 계약 완료");
	}
	
}

class Account {
	
	String accountNo, ownerName;
	int balance, amount;

	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}

	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금하신 금액 : " + amount + "원");
		System.out.println("입금 후 현재잔고 : " + balance + "원");
	}

	public int withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("출금하신 금액 : " + amount + "원");
			System.out.println("출금 후 현재잔고 : " + balance + "원");
			return amount;
		} else {
			System.out.println("잔고가 부족하여 출금이 불가능합니다.");
			return 0;
		}
	}

}