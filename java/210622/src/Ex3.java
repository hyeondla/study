import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex3 extends JFrame {

	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		setBounds(1200, 200, 400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pCenter = new JPanel();
		add(pCenter);
		
		JButton btnMessage = new JButton("Message");
		JButton btnConfirm = new JButton("Confirm");
		JButton btnInput = new JButton("Input");
		
		pCenter.add(btnMessage);
		pCenter.add(btnConfirm);
		pCenter.add(btnInput);
		
		btnMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Message 버튼");
				JOptionPane.showMessageDialog(Ex3.this, "메시지 다이얼로그", "Message Dialog", JOptionPane.QUESTION_MESSAGE, null);
				// Ex3.this -> JFrame 지정
				// this -> ActionListener 지정
			}
		});

		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Confirm 버튼");
				int selectedValue = JOptionPane.showConfirmDialog(Ex3.this, "종료하시겠습니까?", "확인", JOptionPane.OK_CANCEL_OPTION);
				switch (selectedValue) {
					case JOptionPane.YES_OPTION:
						System.out.println("예(Y) 버튼 클릭됨");
//						System.exit(0);
						break;
					case JOptionPane.NO_OPTION:
						System.out.println("아니오(N) 버튼 클릭됨");
						break;
					case JOptionPane.CANCEL_OPTION:
						System.out.println(("취소 버튼 클릭됨"));
						break;
				}
			}
		});

		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Input 버튼");
				String inputData = JOptionPane.showInputDialog(Ex3.this, "검색어를 입력하세요");
				
//				System.out.println(inputData);
				JOptionPane.showMessageDialog(Ex3.this, inputData, "입력 데이터", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex3();
	}

}
