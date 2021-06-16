package event_handling;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class EventHandling1 extends JFrame{

	public EventHandling1() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyWindowListner windowListner = new MyWindowListner(); // 구현체 클래스 인스턴스 생성
		// 컴포넌트(프레임) addXXXListener() 메서드 호출
		addWindowListener(windowListner); // 구현체 클래스 인스턴스 전달
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandling1();
	}

}

// WindowListener 인터페이스 구현 클래스 정의
class MyWindowListner implements WindowListener {

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		// 현재 작업중인 프레임 종료
		System.exit(0); // 현재 프로그램 정상적 강제 종료
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	
}