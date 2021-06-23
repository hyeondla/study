import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class MemberGUI extends JFrame {
	
	JTextField tfNum, tfName, tfAge, tfMail, tfJumin1, tfJumin2;
	
	public MemberGUI() {
		showFrame();
	}

	public void showFrame() {
		
		setBounds(100,200,1024,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원관리 프로그램");
		
		createWestPanel();
		createNorthPanel();
		createSouthPanel();
		
		setVisible(true);
		
	}
	
	public void createWestPanel() {
		
		JPanel p = new JPanel();
		getContentPane().add(p);
		
		JLabel lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setBounds(20, 24, 60, 15);
		tfNum = new JTextField(10);
		tfNum.setBounds(104, 21, 156, 25);
		p.setLayout(null);
		p.add(lblNum);
		p.add(tfNum);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(20, 69, 60, 15);
		tfName = new JTextField(10);
		tfName.setBounds(104, 66, 156, 25);
		p.add(lblName);
		p.add(tfName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(20, 114, 60, 15);
		tfAge = new JTextField(10);
		tfAge.setBounds(104, 111, 156, 25);
		p.add(lblAge);
		p.add(tfAge);
		
		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setBounds(20, 157, 60, 15);
		tfMail = new JTextField(10);
		tfMail.setBounds(104, 154, 156, 25);
		p.add(lblMail);
		p.add(tfMail);
		
		JLabel lblJumin = new JLabel("주민번호");
		lblJumin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumin.setBounds(20, 198, 60, 15);
		tfJumin1 = new JTextField(10);
		tfJumin2 = new JTextField(10);
		tfJumin1.setBounds(104, 193, 65, 25);
		tfJumin2.setBounds(189, 193, 71, 25);
		
		p.add(lblJumin);
		p.add(tfJumin1);
		p.add(tfJumin2);
		
	}
	
	public void createNorthPanel() {
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 4, 30, 5));
		add(p, BorderLayout.NORTH);
		
		JLabel lblIP = new JLabel("IP");
		lblIP.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField tfIP = new JTextField();
		p.add(lblIP);
		p.add(tfIP);
		
		JLabel lblName = new JLabel("Username");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField tfName = new JTextField();
		p.add(lblName);
		p.add(tfName);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField tfPass = new JTextField();
		p.add(lblPass);
		p.add(tfPass);
		
		JButton btnLogin = new JButton("Login");
		p.add(btnLogin);
		
	}
	
	public void createSouthPanel() {
		
		JPanel p = new JPanel();
		add(p, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("회원추가");
		JButton btnList= new JButton("회원목록");
		JButton btnDel = new JButton("회원삭제");
		
		p.add(btnAdd);
		p.add(btnList);
		p.add(btnDel);
		
	}

	public static void main(String[] args) {
		new MemberGUI();
	}
	
}
