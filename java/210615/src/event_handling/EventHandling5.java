package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class EventHandling5 extends JFrame{
	
	public EventHandling5() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 익명 내부클래스를 임시 객체 형태로 구현 (일회성)
		// addWindowListener() 메서드 파라미터에 구현체 바로 전달
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventHandling5();
	}

}
