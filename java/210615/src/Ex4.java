import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex4 extends JFrame {
	
	public Ex4() {
		showFrame();
	}
	
	public void showFrame() {
		setTitle("버튼 연습");
		setBounds(1200, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("버튼");
		add(btn);
		
		JButton btn2 = new JButton("버튼2");
		add(btn2, BorderLayout.EAST);
		
		JButton btn3 = new JButton("버튼3");
		add(btn3, BorderLayout.SOUTH);
		
		JButton btn4 = new JButton("버튼4");
		add(btn4, BorderLayout.WEST);
		
		JButton btn5 = new JButton("버튼5");
		add(btn5, BorderLayout.NORTH);
		
		ActionListener btnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭됨");
				
				if(e.getSource() == btn) {
					System.out.println("CENTER 버튼 클릭");
				} else if(e.getSource() == btn2) {
					System.out.println("EAST 버튼 클릭");
				} else if(e.getSource() == btn3) {
					System.out.println("SOUTH 버튼 클릭");
				} else if(e.getSource() == btn4) {
					System.out.println("WEST 버튼 클릭");
				} else if(e.getSource() == btn5) {
					System.out.println("NORTH 버튼 클릭");
				}
				
			}
		};
		
		btn.addActionListener(btnListener);
		btn2.addActionListener(btnListener);
		btn3.addActionListener(btnListener);
		btn4.addActionListener(btnListener);
		btn5.addActionListener(btnListener);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex4();
	}

}
