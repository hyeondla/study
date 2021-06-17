import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Ex6 extends JFrame {

	public Ex6() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(1000, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
		
//		JButton btnNewButton_1 = new JButton("New button");
//		getContentPane().add(btnNewButton_1);
//		
//		JButton btnNewButton = new JButton("New button");
//		getContentPane().add(btnNewButton);
		
		//----------------------------------------------------------
		
		JPanel pCenter = new JPanel();
		getContentPane().add(pCenter, BorderLayout.CENTER);
		
		pCenter.setLayout(new BorderLayout(10, 10));
		
		JButton btnNewButton = new JButton("Center");
		pCenter.add(btnNewButton, BorderLayout.CENTER);
		
		JButton btnSouth = new JButton("SOUTH");
		pCenter.add(btnSouth, BorderLayout.SOUTH);
		
		//----------------------------------------------------------
		
		JButton btnFrameSouth = new JButton("FrameSouth");
		add(btnFrameSouth, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex6();
	}
	
}
