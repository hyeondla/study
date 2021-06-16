package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test5 extends JFrame {

	public Test5() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("버튼");
		add(btn);
		
//		btn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭됨");
//			}
//		});
		
		// 람다식
		btn.addActionListener(ActionListener -> {
			System.out.println("버튼 클릭됨");
		});
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test5();
	}

}
