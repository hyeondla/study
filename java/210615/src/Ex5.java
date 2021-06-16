import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex5 extends JFrame {

	public Ex5() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		getContentPane().add(p);
		
		//-----------------------------------
		
		JButton btn = new JButton("버튼");
		p.add(btn);
		
		JButton btn2 = new JButton("버튼2");
		p.add(btn2);
		
		JButton btn3 = new JButton("버튼3");
		p.add(btn3);
		
		JButton btn4 = new JButton("버튼4");
		p.add(btn4);
		
		JButton btn5 = new JButton("버튼5");
		p.add(btn5);
		
		JButton btn6 = new JButton("버튼6");
		p.add(btn6);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex5();
	}

}
