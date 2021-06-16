package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test3 extends JFrame {

	public Test3() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("버튼");
		add(btn);
		
		// 로컬 내부클래스
		class MyActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 이벤트 발생시 자동 호출
				System.out.println("버튼 클릭됨");
			}
		}
		
		MyActionListener actionListener = new MyActionListener();
		
		btn.addActionListener(actionListener);
		
		setVisible(true);
	}
	
	// 인스턴스멤버 내부클래스
//	private class MyActionListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// 이벤트 발생시 자동 호출
//			System.out.println("버튼 클릭됨");
//		}
//	}

	public static void main(String[] args) {
		new Test3();
	}

}
