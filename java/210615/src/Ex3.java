import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex3 extends JFrame {
	
	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		setTitle("버튼 연습");
		setBounds(1200, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("버튼");
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭됨");
			}
		});
		
		JButton btn2 = new JButton("버튼2");
		add(btn2, BorderLayout.EAST);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("EAST 버튼 클릭됨");
			}
		});
		
		JButton btn3 = new JButton("버튼3");
		add(btn3, BorderLayout.SOUTH);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("SOUTH 버튼 클릭됨");
			}
		});
		
		JButton btn4 = new JButton("버튼4");
		add(btn4, BorderLayout.WEST);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("WEST 버튼 클릭됨");
			}
		});
		
		JButton btn5 = new JButton("버튼5");
		add(btn5, BorderLayout.NORTH);
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("NORTH 버튼 클릭됨");
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex3();
	}

}
