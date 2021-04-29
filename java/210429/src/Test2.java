
public class Test2 {

	public static void main(String[] args) {

		Account2 acc = new Account2();

//		acc.accountNo = "111-1111-111";
//		acc.ownerName = "홍길동";
//		acc.balance = 10000;

//		System.out.println("계좌번호 : " + acc.accountNo);
//		System.out.println("예금주명 : " + acc.ownerName);
//		System.out.println("현재잔고 : " + acc.balance);
	}

}

class Account2 {

	String accountNo, ownerName;
	int balance;

	public Account2() {
		System.out.println("Account2() 생성자 호출");

		accountNo = "111-1111-111";
		ownerName = "홍길동";
		balance = 0;
		showAccountInfo();
	}

	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance);
	}

}