import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Ex2 extends JFrame {

	JComboBox<String> comboBox;
	
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		
		setBounds(1200, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		comboBox = new JComboBox<String>();
		add(comboBox, BorderLayout.CENTER);
		
		String[] items = {"항목을 선택하세요", "JAVA", "JSP", "Android", "Oracle"};
//		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(items);
//		comboBox.setModel(comboBoxModel);
		
//		comboBox.setModel(new DefaultComboBoxModel<String>(items));
		
		Vector<String> items2 = new Vector<String>();
		items2.add("항목을 선택하세요");
		items2.add("JAVA");
		items2.add("JSP");
		items2.add("Android");
		items2.add("Oracle");
		
		comboBox.setModel(new DefaultComboBoxModel<String>(items));
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("콤보박스 선택됨");
//				System.out.println("선택된 항목 인덱스 : " + comboBox.getSelectedIndex());
//				System.out.println("선택된 항목 이름 : " + comboBox.getSelectedItem());
				
				if(comboBox.getSelectedIndex()!=0) {
					System.out.println("선택된 항목 : " + comboBox.getSelectedItem());
				}
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
