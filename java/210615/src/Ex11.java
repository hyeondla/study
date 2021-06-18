import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex11 extends JFrame {
	
	JTextArea ta;
	JTextField tf;
	
	public Ex11() {
		showFrame();
	}
	
	public void showFrame() {
		
		setBounds(1200, 200, 400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ta = new JTextArea(20, 15);
		ta.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(ta);
		
		getContentPane().add(scrollPane);
		
		//-----------------------------------------
		
		JPanel p = new JPanel();
		add(p, BorderLayout.SOUTH);
		
		tf = new JTextField(20);
		p.add(tf);
		
		JButton btn = new JButton("전송");
		p.add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		
		setVisible(true);
		
		tf.requestFocus();
		
	}
	
	private void sendMessage() {
		String message = tf.getText() + "\n";
		ta.setText(ta.getText() + message);
		tf.setText("");
		tf.requestFocus();
	}
	
	public static void main(String[] args) {
		new Ex11();
	}

}
