import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class MemberGUI_2 extends JFrame {
	JTextField tfDbIp, tfDbUsername;
	JPasswordField pfDbPassword;
	
	JTextField tfIdx, tfName, tfAge, tfEmail1, tfEmail2, tfJumin1, tfJumin2;
	JComboBox<String> comboEmailDomain;
	
	JButton btnLogin;
	
	JTable table;
	
	boolean isLogin; // 로그인상태
	
	public MemberGUI_2() {
		showFrame();
	}
	
	public void showFrame() {
		setTitle("회원관리 프로그램");
		setBounds(600, 400, 1000, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createWestPanel();
		createNorthPanel();
		createSouthPanel();
		createCenterPanel();
		
		setVisible(true);
	}
	
	public void createCenterPanel() {
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane, BorderLayout.CENTER);
		
		// 제목열 데이터
		String[] columnNames = {"번호", "이름", "나이", "E-Mail", "주민번호"};
		
		// 제목열 표시
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // 0행에 표시
		
		table.setModel(tableModel);
		
	}
	
	// 좌측(WEST 영역) 회원정보 입력 패널 생성 메서드
	public void createWestPanel() {
		JPanel pWest = new JPanel();
		pWest.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        getContentPane().add(pWest, BorderLayout.WEST);
        pWest.setLayout(new GridLayout(5, 1, 0, 0));

        
        // 번호 입력 패널
        JPanel pIdx = new JPanel();
        FlowLayout flowLayout = (FlowLayout) pIdx.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        pWest.add(pIdx);
        
        pIdx.add(new JLabel("번 호"));
        
        tfIdx = new JTextField();
        pIdx.add(tfIdx);
        tfIdx.setColumns(12);
        tfIdx.setEditable(false); // 입력창 잠금
        
        
        // 이름 입력 패널
        JPanel pName = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) pName.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        pWest.add(pName);
        
        pName.add(new JLabel("이 름"));
        
        tfName = new JTextField();
        pName.add(tfName);
        tfName.setColumns(12);
        
        
        // 나이 입력 패널
        JPanel pAge = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) pAge.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        pWest.add(pAge);
        
        pAge.add(new JLabel("나이"));
        
        tfAge = new JTextField();
        pAge.add(tfAge);
        tfAge.setColumns(12);

        
        // ------------------------------------------------------
        // E-Mail 입력 패널
        // 입력창과 도메인 선택창을 포함하기 위해 2행 1열로 편성
        JPanel pEmail = new JPanel(new GridLayout(2, 1));
        pWest.add(pEmail);
        
        // E-Mail 입력받기 위한 패널 생성 및 텍스트필드 추가
        JPanel pEmailInput = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) pEmailInput.getLayout();
        flowLayout_3.setAlignment(FlowLayout.RIGHT);
        pEmail.add(pEmailInput);
        
        pEmailInput.add(new JLabel("E-Mail"));
        
        tfEmail1 = new JTextField();
        pEmailInput.add(tfEmail1);
        tfEmail1.setColumns(5);
        
        pEmailInput.add(new JLabel("@"));
        
        tfEmail2 = new JTextField();
        pEmailInput.add(tfEmail2);
        tfEmail2.setColumns(5);
        
        // E-Mail 도메인 선택을 위한 콤보박스 생성 및 부착
        JPanel pEmailDomain = new JPanel();
        FlowLayout flowLayout_3_2 = (FlowLayout) pEmailDomain.getLayout();
        flowLayout_3_2.setAlignment(FlowLayout.RIGHT);
        pEmail.add(pEmailDomain);
        
        
        String[] items = {"직접 입력", "naver.com", "nate.com", "gmail.com"};
        comboEmailDomain = new JComboBox<String>();
        comboEmailDomain.setModel(new DefaultComboBoxModel<String>(items));
        pEmailDomain.add(comboEmailDomain);
        
        comboEmailDomain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String domain = (String) comboEmailDomain.getSelectedItem();
				if(domain.equals("직접 입력")) {
					tfEmail2.setText("");
					tfEmail2.requestFocus();
				} else {
					tfEmail2.setText(domain);
				}
			}
		});
        
        // ------------------------------------------------------
        // 주민번호 입력 패널
        JPanel pJumin = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) pJumin.getLayout();
        flowLayout_4.setAlignment(FlowLayout.RIGHT);
        pWest.add(pJumin);
        
        pJumin.add(new JLabel("주민번호"));
        
        tfJumin1 = new JTextField();
        pJumin.add(tfJumin1);
        tfJumin1.setColumns(5);
        
        pJumin.add(new JLabel("-"));
        
        tfJumin2 = new JTextField();
        pJumin.add(tfJumin2);
        tfJumin2.setColumns(5);
        
	    tfJumin1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println(e.getKeyChar() + " : " + e.getKeyCode());
				char keyChar = e.getKeyChar();
				String jumin1Num = tfJumin1.getText();
				if(Character.isDigit(keyChar)) {
					if(jumin1Num.length() == 6) {
						tfJumin2.requestFocus();
					} else if(jumin1Num.length() > 6) {
						tfJumin1.setText(jumin1Num.substring(0,6));
					}
 				} 
			}
	    });
	}
	
	public void createNorthPanel() {
		// 상단 로그인 패널
		JPanel pNorth = new JPanel(new GridLayout(1, 4));
		pNorth.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		getContentPane().add(pNorth, BorderLayout.NORTH);
		
		JPanel pDbIp = new JPanel();
		pNorth.add(pDbIp);
		
		JLabel lblDbIp = new JLabel("IP");
		pDbIp.add(lblDbIp);
		
		tfDbIp = new JTextField();
		pDbIp.add(tfDbIp);
		tfDbIp.setColumns(10);
		// IP 주소 입력 텍스트필드에 임시로 DB 서버 주소인 localhost 주소 입력
		tfDbIp.setText("localhost");
		tfDbIp.setEditable(false); // 편집 불가 설정
		
		JPanel pDbUsername = new JPanel();
		pNorth.add(pDbUsername);
		
		JLabel lblDbUsername = new JLabel("Username");
		pDbUsername.add(lblDbUsername);
		
		tfDbUsername = new JTextField();
		pDbUsername.add(tfDbUsername);
		tfDbUsername.setColumns(10);
		
		JPanel pDbPassword = new JPanel();
		pNorth.add(pDbPassword);
		
		JLabel lblDbPassword = new JLabel("Password");
		pDbPassword.add(lblDbPassword);
		
		pfDbPassword = new JPasswordField();
		pfDbPassword.setColumns(10);
		pDbPassword.add(pfDbPassword);
		
		JPanel pLoginBtn = new JPanel();
		pNorth.add(pLoginBtn);
		
		btnLogin = new JButton("Login");
		pLoginBtn.add(btnLogin);
		
		// 로그인 버튼 클릭 시 이벤트 처리
		// => DB 계정, 패스워드 중 입력되지 않은 항목에 대한 오류 메세지 출력
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
	}

	public void createSouthPanel() {
		// 하단 버튼 패널
		JPanel pSouth = new JPanel();
		pSouth.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		getContentPane().add(pSouth, BorderLayout.SOUTH);
		
		JButton btnInsert = new JButton("회원추가");
		JButton btnSelect = new JButton("회원목록");
		JButton btnDelete = new JButton("회원삭제");
		
		pSouth.add(btnInsert);
		pSouth.add(btnSelect);
		pSouth.add(btnDelete);
		
		ActionListener btnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!isLogin) { // 로그아웃 상태
					JOptionPane.showMessageDialog(MemberGUI_2.this, "로그인 필수", "로그인 요청", JOptionPane.WARNING_MESSAGE);
					tfDbUsername.requestFocus();
				} else { // 로그인 상태
					if(e.getSource() == btnInsert) {
						insert();
					} else if(e.getSource() == btnSelect) {
						select();
					} else if(e.getSource() == btnDelete) {
						delete();
					}
				}
				
			}
		};
		
		btnInsert.addActionListener(btnListener);
		btnSelect.addActionListener(btnListener);
		btnDelete.addActionListener(btnListener);
		
	}
	
	public void insert() {
		// 입력 항목 체크
		if(tfName.getText().length() == 0) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "이름 입력 필수", "입력 요청", JOptionPane.WARNING_MESSAGE);
			tfName.requestFocus();
			return;
		} else if(tfAge.getText().length() == 0) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "나이 입력 필수", "입력 요청", JOptionPane.WARNING_MESSAGE);
			tfAge.requestFocus();
			return;
		} else if(tfEmail1.getText().length() == 0) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "이메일 입력 필수", "입력 요청", JOptionPane.WARNING_MESSAGE);
			tfEmail1.requestFocus();
			return;
		} else if(tfEmail2.getText().length() == 0) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "이메일 입력 필수", "입력 요청", JOptionPane.WARNING_MESSAGE);
			tfEmail2.requestFocus();
			return;
		} else if(tfJumin1.getText().length() == 0) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "주민등록번호 입력 필수", "입력 요청", JOptionPane.WARNING_MESSAGE);
			tfJumin1.requestFocus();
			return;
		} else if(tfJumin2.getText().length() == 0) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "주민등록번호 입력 필수", "입력 요청", JOptionPane.WARNING_MESSAGE);
			tfJumin2.requestFocus();
			return;
		}
		
		// 입력 완료
		String name = tfName.getText();
		int age = Integer.parseInt(tfAge.getText());
		String email = tfEmail1.getText() + "@" + tfEmail2.getText();
		String jumin = tfJumin1.getText() + "-" + tfJumin2.getText();
		
//		System.out.println("이름 : " + name);
//		System.out.println("나이 : " + age);
//		System.out.println("이메일 : " + email);
//		System.out.println("주민번호 : " + jumin);
		
		MemberDTO dto = new MemberDTO(0, name, age, email, jumin);
		
		// MemberDAO 클래스 인스턴스 생성
		MemberDAO dao = new MemberDAO();
		int insertCount = dao.insert(dto);
		
		if(insertCount == 1) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "회원 추가 완료", "알림", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "회원 추가 실패", "알림", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void select() {
		
		MemberDAO dao = new MemberDAO();
		Vector<Vector> memberList = dao.select();
		
		// DefaultTableModel 객체 가져오기
		// => JTable 객체 getModel() 
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel(); // 다운캐스팅
		
		for(Vector member : memberList) {
//			System.out.println(member);
			tableModel.addRow(member);
		}
		
	}
	
	public void delete() {
		String strIdx = JOptionPane.showInputDialog(MemberGUI_2.this, "삭제할 회원번호를 입력하세요");
//		System.out.println(strIdx);
		
		int selectedBtn = JOptionPane.showConfirmDialog(this, strIdx + "번 회원을 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(selectedBtn == JOptionPane.NO_OPTION) {
			return;
		} 
		
		MemberDAO dao = new MemberDAO();
		int deleteCount = dao.delete(Integer.parseInt(strIdx));
		if(deleteCount == 1) {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "회원 삭제 완료", "알림", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(MemberGUI_2.this, "회원 삭제 실패", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void login() {
		
		if(!isLogin) { // Login
			
			String dbUsername = tfDbUsername.getText();
			String dbPassword = new String(pfDbPassword.getPassword());
			
			if(dbUsername.length()==0) {
				JOptionPane.showMessageDialog(MemberGUI_2.this, "아이디 입력 필수", "로그인 요청", JOptionPane.WARNING_MESSAGE);
				tfDbUsername.requestFocus();
			} else if(dbPassword.length()==0) {
				JOptionPane.showMessageDialog(MemberGUI_2.this, "비밀번호 입력 필수", "로그인 요청", JOptionPane.WARNING_MESSAGE);					
				pfDbPassword.requestFocus();
			} else {
				System.out.println("로그인 작업 수행");
				
				MemberDAO dao = new MemberDAO();
				try {
					boolean loginResult = dao.login(dbUsername, dbPassword);
					
					// 정상 로그인 => Logout으로 버튼 변경
					if(loginResult) {
						btnLogin.setText("Logout");
						isLogin = true;
						tfDbUsername.setEditable(false);
						pfDbPassword.setEditable(false);
					}
					
				} catch (LoginFailedException e1) {
					JOptionPane.showMessageDialog(MemberGUI_2.this, "로그인 실패 - " + e1.getMessage(), "실패", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		} else { // Logout
			
			System.out.println("로그아웃 작업 수행");
			// 정상 로그인 => Logout으로 버튼 변경
			btnLogin.setText("Login");
			isLogin = false;
			tfDbUsername.setEditable(true);
			pfDbPassword.setEditable(true);
			pfDbPassword.setText("");
			
		}
		
	}

	public static void main(String[] args) {
		new MemberGUI_2();
	}

}



















