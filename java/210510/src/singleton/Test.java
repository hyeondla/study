package singleton;

public class Test {

	public static void main(String[] args) {

		Account acc = Account.getInstance();
		
		acc.accountNo = "123-1234-567";
		acc.ownerName = "홍길동";
		acc.balance = 50000;
		
		acc.showAccountInfo();
		
	}

}

class Account {
	
	private static Account instance = new Account();

	String accountNo;
	String ownerName;
	int balance;
	
	private Account() {}

	public static Account getInstance() {
		return instance;
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance);
	}
	
}