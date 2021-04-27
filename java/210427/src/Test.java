
public class Test {

	public static void main(String[] args) {

		Account acc = new Account();

		acc.accountNo = "111-1111-111";
		acc.ownerName = "홍길동";
		acc.balance = 10000;

		System.out.println("계좌번호 : " + acc.accountNo);
		System.out.println("예금주명 : " + acc.ownerName);
		System.out.println("현재잔고 : " + acc.balance + "원");

		System.out.println("--------------------------------");

		Account acc2 = new Account();

		acc2.accountNo = "222-2222-222";
		acc2.ownerName = "김다현";
		acc2.balance = 30000000;

		System.out.println("계좌번호 : " + acc2.accountNo);
		System.out.println("예금주명 : " + acc2.ownerName);
		System.out.println("현재잔고 : " + acc2.balance + "원");

	}

}

class Account {

	String accountNo, ownerName;
	int balance;

}