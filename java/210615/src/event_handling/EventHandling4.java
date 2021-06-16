package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class EventHandling4 extends JFrame{

	public EventHandling4() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 구현체 클래스를 익명 로컬 내부클래스 형태로 정의
		// 변수 선언 (추상클래스 -> 인스턴스 생성 불가 -> new 생성자() { 오버라이딩 }; )
//		WindowAdapter windowAdapter = new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		}; 
		
		// 호출 메서드 동일
		// WindowAdapter -> WindowListener 업캐스팅
		addWindowListener(windowAdapter);
		
		setVisible(true);
	}

	// 구현체 클래스를 익명 내부클래스 형태로 정의
	WindowAdapter windowAdapter = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	};
	
	public static void main(String[] args) {
		new EventHandling4();
	}

}
