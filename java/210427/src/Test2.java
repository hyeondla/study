
public class Test2 {

	public static void main(String[] args) {

		Account2 acc = new Account2();

		acc.accountNo = "123-4567-890";
		acc.ownerName = "홍길동";
		acc.balance = 45399400;

		acc.showAccountInfo();

		System.out.println("------------------------");

		Account2 acc2 = new Account2();

		acc2.accountNo = "123-1234-567";
		acc2.ownerName = "김다현";
		acc2.balance = 98389200;

		acc2.showAccountInfo();

	}

}

class Account2 {

	String accountNo, ownerName;
	int balance;

	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}

}