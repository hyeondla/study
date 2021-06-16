package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test4 extends JFrame {

	public Test4() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("버튼");
		add(btn);
		
		// 익명 로컬 내부클래스
//		ActionListener actionListener = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭됨");
//			}
//		};
		
		btn.addActionListener(actionListener);
		
		setVisible(true);
	}
	
	// 익명 내부클래스
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼 클릭됨");
		}
	};

	public static void main(String[] args) {
		new Test4();
	}

}
