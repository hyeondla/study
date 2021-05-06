
public class Test5 {

	public static void main(String[] args) {
		
		Account5 acc1 = new Account5();
		acc1.showAccountInfo();
		
		Account5 acc2 = new Account5("222-2222-222");
		acc2.showAccountInfo();
		
		Account5 acc3 = new Account5("333-3333-333", "강감찬");
		acc3.showAccountInfo();
		
		Account5 acc4 = new Account5("444-4444-444", "이순신", 900000);
		acc4.showAccountInfo();
				
	}

}

class Account5{
	
	String accountNo;
	String ownerName;
	int balance;
	
	public Account5() {
		this("111-1111-111", "홍길동", 50000);
	}
	
	public Account5(String accountNo) {
		this(accountNo, "홍길동", 50000);
	}
	
	public Account5(String accountNo, String ownerName) {
		this(accountNo, ownerName, 50000);
	}
	
	public Account5(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance);
		System.out.println("-----------------------");
	}
}