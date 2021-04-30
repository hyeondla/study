
public class Test2_2 {

	public static void main(String[] args) {
		
		Account acc1 = new Account();
		System.out.println("--------------------------");
		Account acc2 = new Account("222-2222-222");
		System.out.println("--------------------------");
		Account acc3 = new Account("333-3333-333", "이순신");
		System.out.println("--------------------------");
		Account acc4 = new Account("444-4444-444", "강감찬", 500000000);
		
	}

}

class Account {

	String accountNo, ownerName;
	int balance;
	
	public Account() {
		accountNo = "111-1111-111";
		ownerName = "홍길동";
		balance = 0;
		showAccountInfo();
	}
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		ownerName = "홍길동";
		balance = 0;
		showAccountInfo();
	}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		balance = 0;
		showAccountInfo();
	}
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		showAccountInfo();
	}

	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
}