package thread;

public class Ex3 {

	public static void main(String[] args) {
		
//		YourThread yt1 = new YourThread("▶A작업◀", 1000000);
//		YourThread yt2 = new YourThread("♣B작업♣", 500000);
//		YourThread yt3 = new YourThread("★C작업★", 1000000);
		//Runnable r = new YourThread("★C작업★", 1000000); //업캐스팅
		
//		yt1.run();
//		yt2.run();
//		yt3.run();
		
		//Thread 생성자 public Thread(Runnable target)
//		Thread t1 = new Thread(yt1); 
//		Thread t2 = new Thread(yt2); 
//		Thread t3 = new Thread(yt3); 
		
		//생성자에 인스턴스 직접 전달
		Thread t1 = new Thread(new YourThread("▶A작업◀", 1000000)); 
		Thread t2 = new Thread(new YourThread("♣B작업♣", 500000)); 
		Thread t3 = new Thread(new YourThread("★C작업★", 1000000)); 
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class A {}

// 다중 상속 불가 -> Runnable 인터페이스 구현
class YourThread extends A implements Runnable {
	
	String name;
	int count;
	
	public YourThread(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println(name + " : " + i);
		}
	}
	
}