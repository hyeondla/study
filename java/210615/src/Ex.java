import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Ex extends JFrame {

	public Ex() {
		showFrame();
		showFrame2();
	}
	
	public void showFrame() {
		// 창 크기 설정
//		setSize(300, 200); 
		Dimension d = new Dimension(300, 200);
//		setSize(d);
		
		// 창 위치 조절
//		setLocation(600, 400);
		Point p = new Point(600, 400);
//		setLocation(p);
		
		// 창 위치, 크기 조절
//		setBounds(600, 400, 300, 200);
		Rectangle r = new Rectangle(p, d);
		setBounds(r);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 동작
		
		setVisible(true); // 창 표시
	}
	
	public void showFrame2() { 
		JFrame f1 = new JFrame("프레임-1"); // 인스턴스 생성 (타이틀)
		f1.setBounds(1200, 400, 400, 400); // 인스턴스.메서드 호출
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setVisible(true);
		
		JFrame f2 = new JFrame();
		f2.setTitle("프레임-2"); // 타이틀 설정
		f2.setBounds(200, 600, 300, 400); 
		f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f2.setVisible(true);
	}
	
	public static void main(String[] args) {

		new Ex();
		
	}

}
