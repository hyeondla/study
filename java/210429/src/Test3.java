
public class Test3 {

	public static void main(String[] args) {

		Account3 acc = new Account3("111-1111-111", "홍길동", 30000);
		acc.showAccountInfo();

	}

}

class Account3 {

	String accountNo, ownerName;
	int balance;

	public Account3(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance);
	}

}