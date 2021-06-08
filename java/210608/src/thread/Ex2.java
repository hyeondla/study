package thread;

public class Ex2 {

	public static void main(String[] args) {
		
		//멀티 쓰레딩
		//작업 순서 변동 -> 실행 결과가 다를 수 있음
		
		//멀티쓰레딩 클래스 인스턴스 생성
		MyThread mt1 = new MyThread("▶A작업◀", 1000000);
		MyThread mt2 = new MyThread("♣B작업♣", 500000);
		MyThread mt3 = new MyThread("★C작업★", 1000000);
		//Thread t = new MyThread("★C작업★", 1000000); //업캐스팅
		
		//멀티쓰레딩 코드 실행
		//=> run() 메서드 호출 시 싱글 쓰레딩으로 처리
//		mt1.run();
//		mt2.run();
//		mt3.run();
		
		//=> start() 메서드 호출
		mt1.start();
		mt2.start();
		mt3.start();
		
	}

}

class MyThread extends Thread { //Thread 클래스 상속
	
	String name;
	int count;
	
	public MyThread(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	//run() 오버라이딩 -> 멀티쓰레딩으로 처리할 코드 작성
	@Override
	public void run() {
		for(int i=1; i<=count; i++) {
			System.out.println(name + " : " + i);
		}
	}
	
}
