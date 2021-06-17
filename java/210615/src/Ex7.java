import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ex7 extends JFrame {
	
	JTextField tf;
	JTextArea ta;
	
	public Ex7() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(1000, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JTextField tf = new JTextField();
//		add(tf, BorderLayout.SOUTH);
		
//		JTextArea ta = new JTextArea();
//		add(ta, BorderLayout.CENTER);
		
		JPanel pCenter = new JPanel();
		getContentPane().add(pCenter, BorderLayout.CENTER);
		
		ta = new JTextArea(20, 30);
		ta.setBackground(SystemColor.activeCaption);
		pCenter.add(ta);
		
		ta.setEditable(false);
		
		//---------------------------------------------------
		
		JLabel label = new JLabel("채팅 서비스");
		label.setFont(new Font("바탕", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label, BorderLayout.NORTH);
		
		//---------------------------------------------------
		
		JPanel pSouth = new JPanel();
		getContentPane().add(pSouth, BorderLayout.SOUTH);
		
		tf = new JTextField(20);
		tf.setFont(new Font("바탕", Font.PLAIN, 16));
		pSouth.add(tf);
		
		JButton btnSend = new JButton("전송");
		pSouth.add(btnSend);
		
		//----------------------------------------------------
		
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendText();
			}
		});
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendText();
			}
		});
		
		setVisible(true);
		
		tf.requestFocus();
		
	}
	
	public void sendText() {
		String msg = tf.getText() + "\n"; // 줄바꿈
//		System.out.println("입력 텍스트 : " + msg);
		ta.setText(ta.getText() + msg); // 텍스트박스에 표시
		
		tf.setText(""); // 입력 텍스트 삭제
		tf.requestFocus(); // 커서
	}
	
	public static void main(String[] args) {
		new Ex7();
	}
	
}
