package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class EventHandling3 extends JFrame{

	public EventHandling3() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 구현체 클래스를 로컬내부클래스 형태로 정의 -> 접근제한자 지정 불가
		class MyWindowAdapter extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		
		MyWindowAdapter windowAdapter = new MyWindowAdapter();
		
		// 호출 메서드 동일
		// WindowAdapter -> WindowListener 업캐스팅
		addWindowListener(windowAdapter);
		
		setVisible(true);
	}
	
	/*
	// 구현체 클래스를 내부클래스 형태로 정의 -> 접근제한자 private
	private class MyWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	*/
	
	public static void main(String[] args) {
		new EventHandling3();
	}

}
