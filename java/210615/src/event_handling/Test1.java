package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 extends JFrame {

	public Test1() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("버튼");
		add(btn);
		
		MyActionListener actionListener = new MyActionListener();
		
		btn.addActionListener(actionListener);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test1();
	}

}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트 발생시 자동 호출
		System.out.println("버튼 클릭됨");
	}
	
}