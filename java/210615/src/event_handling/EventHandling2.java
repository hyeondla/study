package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class EventHandling2 extends JFrame{

	public EventHandling2() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyWindowAdapter windowAdapter = new MyWindowAdapter();
		
		// 호출 메서드 동일
		// WindowAdapter -> WindowListener 업캐스팅
		addWindowListener(windowAdapter);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandling2();
	}

}

// 어댑터 클래스 구현체 클래스 정의
class MyWindowAdapter extends WindowAdapter {
	// 선택적 오버라이딩
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}