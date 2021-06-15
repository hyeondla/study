import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex2 extends JFrame {

	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		setTitle("버튼 프레임");
		setBounds(600, 300, 300, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 버튼 생성
		JButton btn = new JButton("버튼"); // 생성자 파라미터에 문자열 전달
		
		// 버튼 부착
		add(btn);
		
		// 버튼 이벤트 처리
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭됨"); // 콘솔 출력
				JOptionPane.showMessageDialog(null, "버튼 클릭됨"); // 새 창 출력
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
