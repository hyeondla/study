import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Stack;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Ex10 extends JFrame {
		
	JTextField jf;
	Stack<String> numberStack = new Stack<String>();
	
	public Ex10() {
		showFrame();
	}
	
	public void showFrame() {
		
		setBounds(1200, 200, 300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JPanel p = new JPanel();
//		getContentPane().add(p, BorderLayout.CENTER);
//		p.setLayout(new GridLayout(3, 2, 0, 0));
//		
//		JButton btn1 = new JButton("Button1");
//		p.add(btn1);
//		
//		JButton btn2 = new JButton("Button2");
//		p.add(btn2);
//		
//		JButton btn3 = new JButton("Button3");
//		p.add(btn3);
//		
//		JButton btn4 = new JButton("Button4");
//		p.add(btn4);
//		
//		JButton btn5 = new JButton("Button5");
//		p.add(btn5);
		
		//NORTH
		jf = new JTextField();
		jf.setEditable(false);
		jf.setText("0");
		jf.setHorizontalAlignment(SwingConstants.RIGHT);
		jf.setFont(new Font("굴림", Font.BOLD, 30));
		getContentPane().add(jf, BorderLayout.NORTH);
		
		//CENTER
		JPanel p = new JPanel();
		getContentPane().add(p, BorderLayout.CENTER);
		p.setLayout(new GridLayout(5, 4, 0, 0));
		
		JButton btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;
		JButton btnBack, btnAdd, btnSub, btnMul, btnDiv, btnC, btnCE, btnEqual, btnDot, btnSign;
		
		btnNum0 = new JButton("0");
		btnNum0.setBackground(Color.WHITE);
		btnNum0.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum1 = new JButton("1");
		btnNum1.setBackground(Color.WHITE);
		btnNum1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum2 = new JButton("2");
		btnNum2.setBackground(Color.WHITE);
		btnNum2.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum3 = new JButton("3");
		btnNum3.setBackground(Color.WHITE);
		btnNum3.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum4 = new JButton("4");
		btnNum4.setBackground(Color.WHITE);
		btnNum4.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum5 = new JButton("5");
		btnNum5.setBackground(Color.WHITE);
		btnNum5.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum6 = new JButton("6");
		btnNum6.setBackground(Color.WHITE);
		btnNum6.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum7 = new JButton("7");
		btnNum7.setBackground(Color.WHITE);
		btnNum7.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum8 = new JButton("8");
		btnNum8.setBackground(Color.WHITE);
		btnNum8.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNum9 = new JButton("9");
		btnNum9.setBackground(Color.WHITE);
		btnNum9.setFont(new Font("굴림", Font.PLAIN, 20));
		
		btnBack = new JButton("←");
		btnBack.setFont(new Font("굴림", Font.PLAIN, 20));
		btnAdd = new JButton("+");
		btnAdd.setFont(new Font("굴림", Font.PLAIN, 20));
		btnSub = new JButton("-");
		btnSub.setFont(new Font("굴림", Font.PLAIN, 20));
		btnMul = new JButton("×");
		btnMul.setFont(new Font("굴림", Font.PLAIN, 20));
		btnDiv = new JButton("÷");
		btnDiv.setFont(new Font("굴림", Font.PLAIN, 20));
		btnC = new JButton("C");
		btnC.setFont(new Font("굴림", Font.PLAIN, 20));
		btnCE = new JButton("CE");
		btnCE.setFont(new Font("굴림", Font.PLAIN, 20));
		btnEqual = new JButton("=");
		btnEqual.setFont(new Font("굴림", Font.PLAIN, 20));
		btnDot = new JButton(".");
		btnDot.setFont(new Font("굴림", Font.PLAIN, 20));
		btnSign = new JButton("±");
		btnSign.setFont(new Font("굴림", Font.PLAIN, 20));
		
		p.add(btnCE);
		p.add(btnC);
		p.add(btnBack);
		p.add(btnDiv);
		
		p.add(btnNum7);
		p.add(btnNum8);
		p.add(btnNum9);
		p.add(btnMul);
		
		p.add(btnNum4);
		p.add(btnNum5);
		p.add(btnNum6);
		p.add(btnSub);
		
		p.add(btnNum1);
		p.add(btnNum2);
		p.add(btnNum3);
		p.add(btnAdd);
		
		p.add(btnSign);
		p.add(btnNum0);
		p.add(btnDot);
		p.add(btnEqual);
		
		btnNum0.addActionListener(btnListener);
		btnNum1.addActionListener(btnListener);
		btnNum2.addActionListener(btnListener);
		btnNum3.addActionListener(btnListener);
		btnNum4.addActionListener(btnListener);
		btnNum5.addActionListener(btnListener);
		btnNum6.addActionListener(btnListener);
		btnNum7.addActionListener(btnListener);
		btnNum8.addActionListener(btnListener);
		btnNum9.addActionListener(btnListener);
		btnBack.addActionListener(btnListener);
		btnAdd.addActionListener(btnListener);
		btnSub.addActionListener(btnListener);
		btnMul.addActionListener(btnListener);
		btnDiv.addActionListener(btnListener);
		btnC.addActionListener(btnListener);
		btnCE.addActionListener(btnListener);
		btnEqual.addActionListener(btnListener);
		btnDot.addActionListener(btnListener);
		btnSign.addActionListener(btnListener);
		
		setVisible(true);
		
	}
	
	ActionListener btnListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource(); // 다운캐스팅 
//			System.out.println(btn.getActionCommand());
			/*
			switch(btn.getActionCommand()) {
				case "0" : System.out.println("0번 버튼 클릭됨"); break; 
				case "1" : System.out.println("1번 버튼 클릭됨"); break; 
				case "2" : System.out.println("2번 버튼 클릭됨"); break;
				// (생략) 
			}
			*/
			String actionCommand = btn.getActionCommand();
			if(Character.isDigit(actionCommand.charAt(0))) {
//				System.out.println(actionCommand + " 버튼 클릭됨");
				String number = jf.getText();
				if(number.equals("0")) {
					jf.setText(actionCommand);
				} else {
					jf.setText(number + actionCommand);
				}
			} else {
//				System.out.println(actionCommand + " 버튼 클릭됨");
				String number = jf.getText();
				if(actionCommand.equals("C")) {
					jf.setText("0");
				} else if(actionCommand.equals("←")) {
					if(!number.equals("0")) {
						if(number.length()<=1) {
							jf.setText("0");
						} else {
							if(number.length() == 2) {
								if(!number.contains("-")) {
									jf.setText(number.substring(0, number.length()-1));
								} else {
									jf.setText("0");
								}
							} else {
								jf.setText(number.substring(0, number.length()-1));
							}
						}
					}
				} else if(actionCommand.equals("±")) {
					if(!number.equals("0")) {
						if(number.charAt(0) == '-') {
							jf.setText(number.substring(1));
						} else {
							jf.setText("-" + number);
						}
					}
					/*
					int num = Integer.parseInt(number);
					if(num != 0) {
						num = -num;
					}
					jf.setText(num + "");
					*/
				} else if(actionCommand.equals("+")) {
					if(numberStack.size() > 0) {
//						System.out.println("기존 데이터 있음");
						BigInteger bi1 = new BigInteger(numberStack.pop());
						BigInteger bi2 = new BigInteger(jf.getText());
						numberStack.push(bi1.add(bi2).toString());
						jf.setText("0");
					} else {
//						System.out.println("기존 데이터 없음");
						numberStack.push(jf.getText());
						jf.setText("0");
					}
				} else if(actionCommand.equals("=")) {
					jf.setText(numberStack.pop());
				}
			}
		}
	};
	
	public static void main(String[] args) {
		new Ex10();
	}

}
