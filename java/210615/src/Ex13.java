import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex13 extends JFrame {
	
	public Ex13() {
		showFrame();
	}
	
	public void showFrame() {
		
		setBounds(1200, 200, 400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		
		CardLayout cardLayout = new CardLayout();
		
		JPanel pCenter = new JPanel();
		pCenter.setLayout(cardLayout);
		add(pCenter, BorderLayout.CENTER);
		
		JButton btn1 = new JButton("JAVA");
		JButton btn2 = new JButton("JSP");
		JButton btn3 = new JButton("ORACLE");
		
		pCenter.add(btn1);
		pCenter.add(btn2);
		pCenter.add(btn3);

		JPanel pSouth = new JPanel(new GridLayout(1, 2));
		add(pSouth, BorderLayout.SOUTH);
		
		JButton btnPrev = new JButton("이전");
		JButton btnNext = new JButton("다음");
		
		pSouth.add(btnPrev);
		pSouth.add(btnNext);
		
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.previous(pCenter);
			}
		});
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(pCenter);
			}
		});
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex13();
	}

}
