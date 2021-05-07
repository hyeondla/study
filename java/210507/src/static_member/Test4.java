package static_member;

public class Test4 {

	public static void main(String[] args) {
		
//		Account acc = new Account();
		Account acc = Account.getAcc();
		
		acc.setAccountNo("123-1234-123");
		acc.showAccountInfo();
		
		
	}

}

class Account {
	
	//===========싱글톤==============
	
	private static Account acc = new Account();
	
	private Account() {}
	
	public static Account getAcc() {
		return acc;
	}
	
	//===============================
	
	private String accountNo;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
	}
	
}