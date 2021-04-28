
public class Test2 {

	public static void main(String[] args) {

		Account acc = new Account();
		acc.accountNo = "111-1111-111";
		acc.ownerName = "홍길동";
		acc.balance = 10000;
		acc.showAccountInfo();

		System.out.println("-------------------------------------");

		acc.deposit(900000);

		System.out.println("-------------------------------------");

		acc.withdraw(50000);

		System.out.println("-------------------------------------");

		System.out.println(acc.withdraw(9000000));

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
