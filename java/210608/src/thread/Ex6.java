package thread;

public class Ex6 {

	public static void main(String[] args) {
		
		Account account = new Account(10000);
		
		WithdrawThread iBanking = new WithdrawThread("인터넷뱅킹", account, 3000);
		WithdrawThread mBanking = new WithdrawThread("모바일뱅킹", account, 3000);
				
		iBanking.start();
		mBanking.start();
	}

}

class Account {
	
	int balance;

	public Account(int balance) {
		super();
		this.balance = balance;
	}
	
	public synchronized int deposit(int amount) {
		balance += amount;
		return balance;
	}
	
	public synchronized int withdraw(int amount) {
		String threadName = Thread.currentThread().getName();
		
		if(amount <= balance) {
			balance -= amount;
		} else {
			System.out.println(threadName + "- 잔액 부족");
			amount = 0;
		}
		System.out.println(threadName + " - 출금 금액 : " + amount + ", 잔액 : " + balance);
		return amount;
	}
	
}

class WithdrawThread extends Thread {
	Account account;
	int amount;
	
	public WithdrawThread(String threadName, Account account, int amount) {
		super(threadName);
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int money = account.withdraw(amount);
		}
	} 
	
	
}