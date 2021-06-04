package thread;

public class Ex {

	public static void main(String[] args) {
		
		// 싱글 쓰레드
		
		NoThread nt1 = new NoThread("▶A작업◀", 1000000);
		NoThread nt2 = new NoThread("♣B작업♣", 500000);
		NoThread nt3 = new NoThread("★C작업★", 1000000);
		
		nt1.run();
		nt2.run();
		nt3.run();
		
	}

}

class NoThread {
	
	String name;
	int count;
	
	public NoThread(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println(name + " : " + i);
		}
	}
	
}