package thread;

import java.time.LocalTime;

public class Ex5 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<100000; i++) {
					System.out.println("*****");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<100000; i++) {
					System.out.println("●●●●●");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
//		System.out.println("t1 쓰레드 우선순위 : " + t1.getPriority()); // 기본 우선순위 5
//		System.out.println("t2 쓰레드 우선순위 : " + t2.getPriority());
		
		t1.setPriority(Thread.MIN_PRIORITY); // 우선순위 1
		t2.setPriority(Thread.MAX_PRIORITY); // 우선순위 10

		System.out.println("t1 쓰레드 우선순위 : " + t1.getPriority());
		System.out.println("t2 쓰레드 우선순위 : " + t2.getPriority());
		
		t1.start();
		t2.start();
		
		for(int i=0; i<10; i++) {
			LocalTime now = LocalTime.now();
			System.out.println(now);
			
			try {
				Thread.sleep(1000); // 1초보다 조금 더 긺
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
