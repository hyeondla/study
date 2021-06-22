import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex extends JFrame {

	JCheckBox cb1, cb2, cb3, cbAll;
	JRadioButton rb1, rb2, rb3;
	JLabel lblRadio;
	
	public Ex() {
		showFrame();
	}
	
	public void showFrame() {
		
		setBounds(1200, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(4, 1));
		
		//-------------------------------------------
		
		JPanel p1 = new JPanel();
		add(p1);
		
		JLabel lblTitle = new JLabel("체크박스 & 라디오버튼");
		p1.add(lblTitle);
		
		//-------------------------------------------
		
		JPanel p2 = new JPanel();
		add(p2);
		
		cb1 = new JCheckBox("1번");
		p2.add(cb1);
		
		cb2 = new JCheckBox("2번", true);
		p2.add(cb2);
		
		cb3 = new JCheckBox("3번", false);
		p2.add(cb3);
		
		cbAll = new JCheckBox("전체 선택", false);
		p2.add(cbAll);
		
//		cb1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				System.out.println("1번 체크박스 클릭됨");
//				System.out.println("1번 체크박스 : " + cb1.isSelected());
//			}
//		});
		
		cb1.addActionListener(cbListener);
		cb2.addActionListener(cbListener);
		cb3.addActionListener(cbListener);
		cbAll.addActionListener(cbListener);
		
		//-------------------------------------------
		
		JPanel p3 = new JPanel();
		add(p3);
		
		rb1 = new JRadioButton("1번");
		p3.add(rb1);
		
		rb2 = new JRadioButton("2번", true);
		p3.add(rb2);
		
		rb3 = new JRadioButton("3번", false);
		p3.add(rb3);
		
		// 라디오버튼 그룹화 -> ButtonGroup 객체 생성
		ButtonGroup rbGroup = new ButtonGroup();
		rbGroup.add(rb1);
		rbGroup.add(rb2);
		rbGroup.add(rb3);
		
		rb1.addActionListener(rbListener);
		rb2.addActionListener(rbListener);
		rb3.addActionListener(rbListener);
		
		lblRadio = new JLabel("선택 : ");
		p3.add(lblRadio);
		
		//-------------------------------------------
		
		JPanel p4 = new JPanel();
		add(p4);
		
		JButton b1 = new JButton("저장");
		p4.add(b1);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("저장 버튼 클릭됨");
				insert();
			}
		});
		
		JButton b2 = new JButton("조회");
		p4.add(b2);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("조회 버튼 클릭됨");
				select();
			}
		});
		
		JButton b3 = new JButton("취소");
		p4.add(b3);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("취소 버튼 클릭됨");
				
				cb1.setSelected(false);
				cb2.setSelected(false);
				cb3.setSelected(false);
				cbAll.setSelected(false);
				
//				rbGroup.clearSelection();  // 모두 지우기
				rb2.setSelected(true); // 기본값
				
				
			}
		});

		//-------------------------------------------
		
		setVisible(true);
	}
	
	
	ActionListener cbListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println("체크박스 클릭됨");
			JCheckBox cb = (JCheckBox)e.getSource();
//			System.out.println(cb.getText() + " : " + cb.isSelected());
//			if(cb.getText().equals("전체 선택")) {}
			if(cb == cbAll) {
				if(cb.isSelected()) {
//					System.out.println("체크");
					cb1.setSelected(true);
					cb2.setSelected(true);
					cb3.setSelected(true);
				} else {
					cb1.setSelected(false);
					cb2.setSelected(false);
					cb3.setSelected(false);
				}
			}
		} 
	};
	
	ActionListener rbListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton rb = (JRadioButton)e.getSource();
//			System.out.println(rb.getText() + " 클릭됨");
			lblRadio.setText("선택 : " + rb.getText());
		} 
	};
	
	public void insert() {
		String rbSelectedItem = "";
		if(rb1.isSelected()) {
			rbSelectedItem = rb1.getText();
		} else if(rb2.isSelected()) {
			rbSelectedItem = rb2.getText();
		} else if(rb3.isSelected()) {
			rbSelectedItem = rb3.getText();
		}
		System.out.println(rbSelectedItem);

		String cbSelectedItems = "";
		if(cb1.isSelected()) {
			cbSelectedItems += cb1.getText() + "/";
		} 
		if(cb2.isSelected()) {
			cbSelectedItems += cb2.getText() + "/";
		}
		if(cb3.isSelected()) {
			cbSelectedItems += cb3.getText() + "/";
		}
		System.out.println(cbSelectedItems);
	}
	
	public void select() {
		String rbSelectedItem = "3번";
		String cbSelectedItems = "1번/3번/";
		
		String[] cbSelect = cbSelectedItems.split("/");
//		System.out.println(Arrays.toString(cbSelect));
		
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		for(String cb : cbSelect) {
			if(cb1.getText().equals(cb)) {
				cb1.setSelected(true);
			}
			if(cb2.getText().equals(cb)) {
				cb2.setSelected(true);
			}
			if(cb3.getText().equals(cb)) {
				cb3.setSelected(true);
			}
		}
		
		if(rb1.getText().equals(rbSelectedItem)) {
			rb1.setSelected(true);
		} else if(rb2.getText().equals(rbSelectedItem)) {
			rb2.setSelected(true);
		} else if(rb3.getText().equals(rbSelectedItem)) {
			rb3.setSelected(true);
		}
	}
	
	public static void main(String[] args) {
		new Ex();
	}

}
