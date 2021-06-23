import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ex4 extends JFrame {
	private JTextField textId;
	private JPasswordField passwordPw;
	
	public Ex4() {
		setTitle("회원 로그인");
		showFrame();
	}
	
	public void showFrame() {
		
		setBounds(1000, 200, 315, 242);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pCenter = new JPanel();
		getContentPane().add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(null);
		
		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(146, 134, 97, 23);
		pCenter.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resetValue = JOptionPane.showConfirmDialog(Ex4.this, "리셋하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if(resetValue == JOptionPane.YES_OPTION) {
					clearText();
				} else {
					JOptionPane.showMessageDialog(Ex4.this, "취소되었습니다", "메시지", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setBounds(24, 134, 97, 23);
		pCenter.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = textId.getText();
				String password = new String(passwordPw.getPassword());
				
				if(id.length() == 0) {
					JOptionPane.showMessageDialog(Ex4.this, "아이디 입력 필수", "오류", JOptionPane.ERROR_MESSAGE);
					textId.requestFocus();
					return;
				} else if(password.length() == 0) {
					JOptionPane.showMessageDialog(Ex4.this, "비밀번호 입력 필수", "오류", JOptionPane.ERROR_MESSAGE);
					passwordPw.requestFocus();
					return;
				}
				
				System.out.println("아이디 : " + id);
				System.out.println("비밀번호 : " + password);
				
				clearText();
			}
		});
		
		JLabel labelId = new JLabel("아이디");
		labelId.setBounds(47, 35, 57, 15);
		pCenter.add(labelId);
		
		JLabel labelPw = new JLabel("패스워드");
		labelPw.setBounds(36, 76, 57, 15);
		pCenter.add(labelPw);
		
		textId = new JTextField();
		textId.setBounds(115, 32, 116, 21);
		pCenter.add(textId);
		textId.setColumns(10);
		
		passwordPw = new JPasswordField();
		passwordPw.setEchoChar('*');
		passwordPw.setBounds(115, 73, 116, 21);
		pCenter.add(passwordPw);
		passwordPw.setColumns(10);
		
		setVisible(true);
		
	}
	
	public void clearText() {
		textId.setText("");
		passwordPw.setText("");
		textId.requestFocus();
	}
	public static void main(String[] args) {
		new Ex4();
	}
}
