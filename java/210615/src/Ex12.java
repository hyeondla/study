import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Ex12 extends JFrame {
	
	public Ex12() {
		showFrame();
	}
	
	public void showFrame() {
		
		setBounds(1200, 200, 400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel p1 = new JPanel();
		JButton btn1 = new JButton("버튼1");
		p1.add(btn1);
		tabbedPane.add(p1, "탭1");
		
		JPanel p2 = new JPanel();
		JButton btn2 = new JButton("버튼2");
		p2.add(btn2);
		tabbedPane.add(p2, "탭2");
		
		JPanel p3 = new JPanel();
		JButton btn3 = new JButton("버튼3");
		p3.add(btn3);
		tabbedPane.add(p3, "탭3");
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex12();
	}

}
