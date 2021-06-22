> WindowBuilder 설치

Help > Eclipse Marketplace > 검색 > Install

<img src="./img/swing001.PNG"><br>

<img src="./img/swing002.PNG"><br>

설치 후 이클립스 재시작

자바 파일 우클릭 → Open With → WindowBuilder Editor → Design 탭

<img src="./img/swing003.PNG"><br>

<img src="./img/swing004.PNG"><br>

<br>

---

<br>

> 창 구현하기 - JFrame

1. JFrame 클래스를 상속받아 창 구현

   ```java
   public class Ex extends JFrame {
   	public Ex() {
           showFrame();
       }
       
       public void showFrame() {
           //창 이름 설정
           setTitle("타이틀명");
           
       	// 창 크기 조정
           setSize(가로, 세로);
           Dimension d = new Dimension(가로, 세로);
           setSize(d);
           
           // 창 위치 조정 → 시작점 지정
           setLocation(x, y);
           Point p = new Point(x, y);
           setLocation(p);
           
           // 창 위치 & 크기 조정
           setBounds(x, y, 가로, 세로);
           Rectangle r = new Rectangle(p, d); // Point 객체, Dimension 객체
           setBounds(r);
           
           // 창 닫기 버튼 동작 설정
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 (모든 창 종료)
           setDefaultCloseOperation(JFrame.DIPOSE_ON_CLOSE); // 해당 창 종료
           setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 창 숨김 (기본값)
           setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // 아무 동작 안함
           
           // 창 표시 기능 설정
           setVisible(true);
       }
   }
   ```

2. JFrame 클래스 인스턴스를 생성하여 창 구현

   창을 여러개 생성해야할 때 사용

   ```java
   public void showFrame() {
       JFrame f = new JFrame();
       f.setTitle("타이틀");
       f.setBounds(x, y, 가로, 세로);
       f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f.setVisible(true);
   }
   ```

<br>

> 컴포넌트(버튼) 만들기 - JButton

이벤트 : 컴포넌트에 어떤 동작이 발생하는 것

리스너 : 이벤트 발생을 감지하는 객체

이벤트 핸들링 : XXXListener를 통해 이벤트 발생 시 특정 동작을 수행하게 함

→ 이벤트가 사용되는 대상 컴포넌트의 addXXXListener() 메서드를 호출하여 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;리스너 인터페이스의 구현체를 파라미터로 전달

```java
// JButton 클래스 인스턴스 생성
JButton btn = new JButton("버튼명");

// 프레임 객체의 add() 메서드 호출 → 버튼 부착
add(btn); // JFrame을 상속받은 경우 JFrame.add를 호출하게 됨
this.add(btn); // this 생략 가능

// 버튼 이벤트 처리
btn.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
        // 버튼 클릭 시 자동 호출되어 실행됨
        System.out.println("콘솔 창에 이벤트 메시지 출력")
		JOptionPane.showMessageDialog(null, "팝업 창에 이벤트 메시지 출력");
	}
});
```

<br>

>  컴포넌트(버튼) 배치 - BorderLayout

동, 서, 남, 북, 중앙(기본값) 영역에 배치

하나의 영역당 하나의 컴포넌트만 배치 

→ 중복시 나중에 배치된 컴포넌트가 표시됨, 이전의 컴포넌트는 뒤로 가려짐

영역상수 : BorderLayout.XXX 형태로 지정, CENTER / EAST / WEST / NORTH / SOUTH

레이아웃의 크기가 변해도 내부 컴포넌트의 위치는 변하지 않음, 크기만 변함

JFrame 객체의 기본 레이아웃

```java
add(btn, BorderLayout.CENTER); 
add(btn, BorderLayout.EAST);
add(btn, BorderLayout.WEST);
add(btn, BorderLayout.NORTH);
add(btn, BorderLayout.SOUTH);
```

<br>

> 이벤트 핸들링

1단계 : **리스너 인터페이스를 구현**하는 구현체 클래스를 정의하여 이벤트 처리 - **implements**

- **프레임**(윈도우)의 동작을 처리하는 리스너 : **WindowListener** 인터페이스
- **버튼**의 동작을 처리하는 리스너 : **ActionListener** 인터페이스

```java
// WindowListener 인터페이스를 구현하는 구현체 클래스 정의
class MyWindowListener implements WindowListener {
    // 프레임에서 발생하는 이벤트에 따라 각각 다른 메서드 호출
    // → 추상메서드 구현
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}

public class EventHandling extends JFrame {
    ...
    public void showFrame(){
        ...
        // 구현체 클래스 인스턴스 생성
        MyWindowListener listener = new MyWindowListener(); 
        // 컴포넌트(프레임)의 addXXXListener 메서드 호출
        // → 구현체 클래스 인스턴스 전달
        addWindowListener(listener);
		...
    }
    ...
}
```

2단계 : 리스너 인터페이스 대신 **어댑터 클래스**의 서브클래스를 정의 - **extends**

어댑터 클래스를 상속받아 **필요한 메서드만 오버라이딩** 가능

ActionListener 인터페이스는 추상메서드가 하나뿐이라 어댑터 클래스가 제공되지 않음

```java
// 어댑터 클래스의 서브클래스 정의
class MyWindowAdapter extends WindowAdapter {
	// 필요한 메서드만 선택적 오버라이딩
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

public class EventHandling extends JFrame {
    ...
    public void showFrame(){
        ...
        MyWindowAdapter adapter = new MyWindowAdapter();
        // 컴포넌트(프레임)의 addXXXListener 메서드 호출
        // WindowAdapter → WindowListener 업캐스팅
        addWindowListener(adapter);
		...
    }
    ...
}
```

3단계 : 구현체 클래스를 **내부 클래스** 형태로 정의

구현체 클래스는 GUI 클래스 전용으로 사용하는 경우가 대부분이므로 내부클래스로 정의

- 로컬 내부 클래스로 정의하는 경우
- 인스턴스 내부 클래스로 정의하는 경우

```java
public void showFrame() {		
	// 로컬 내부 클래스 형태로 정의 시 메서드 내에서 정의 필요
	// 현재 메서드 내에서만 사용하는 메서드 전용 클래스
	// → 로컬 내부 클래스는 접근제한자 지정 불가
	class MyWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {}
	}
    
    MyWindowAdapter adapter = new MyWindowAdapter();
	addWindowListener(adapter);	
    
}

// 인스턴스 내부 클래스 형태로 정의 시 메서드 밖에서 정의 필요
// 접근제한자를 private 으로 지정하면 외부에서 접근 불가능
// 현재 클래스의 인스턴스에서만 사용하는 인스턴스 전용클래스
private class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {}
}
```

4단계 : 구현체 클래스를 **익명 내부 클래스** 형태로 정의

변수 선언, 인스턴스 생성, 추상메서드 구현를 한꺼번에 수행

```java
public void showFrame() {
	...
	WindowAdapter adapter = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {}
	};
	
    addWindowListener(adapter);
	...
}

WindowAdapter adapter = new WindowAdapter() {
	@Override
	public void windowClosing(WindowEvent e) {}
};
```

5단계 : 익명 내부 클래스를 임시 객체 형태로 구현하여 사용

1회용 객체로써 한 번 사용 후 제거됨, 다른 컴포넌트에서 사용 불가

```java
public void showFrame() {
	...
	// addWindowListener() 메서드를 호출
    // 메서드 파라미터에 WindowListener/WindowAdapter 구현체를 바로 전달
	// → 참조변수 없이 객체 생성, 메서드 구현, 객체를 파라미터로 전달을 한꺼번에 수행
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {}
	});
    //------------------------------------------------------
    JButton btn = new JButton("버튼");
	add(btn);
    btn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
            System.out.println("버튼 클릭됨");
        }
	});
    // 람다식
    btn.addActionListener(ActionListener -> {
		System.out.println("버튼 클릭됨");
	});
    ...
}
```

<br>

> 버튼 구별, 동작

```java
public void showFrame(){
    // 버튼 생성, 부착
	JButton btnCenter = new JButton("CENTER");  
    JButton btnEast = new JButton("EAST");
	JButton btnWest = new JButton("WEST");
	JButton btnNorth = new JButton("NORTH");
	JButton btnSouth = new JButton("SOUTH");
    add(btnCenter);
    add(btnEast, BorderLayout.EAST);
    add(btnWest, BorderLayout.WEST);
    add(btnNorth, BorderLayout.NORTH);
	add(btnSouth, BorderLayout.SOUTH);
    
    // 버튼이 모두 한 가지 동작만 수행하는 경우
    // → 4단계로 한 번만 구현 후 모두 연결
    ActionListener btnListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
            // 구현체 내에서 각 컴포넌트를 구별해야하는 경우
            // → 자동으로 호출되는 메서드 내의 파라미터로 전달받은 객체 활용
            // → getSource() 메서드로 이벤트가 발생한 객체를 가져오고
            //   컴포넌트 객체의 값을 비교하여 동일한 객체인지 판별
            if(e.getSource() == btnCenter) {
				System.out.println("CENTER 버튼 클릭됨");
			} else if(e.getSource() == btnEast) { 
				System.out.println("EAST 버튼 클릭됨");
			} else if(e.getSource() == btnWest) { 
				System.out.println("WEST 버튼 클릭됨");
			} else if(e.getSource() == btnNorth) { 
				System.out.println("NORTH 버튼 클릭됨");
			} else if(e.getSource() == btnSouth) {
				System.out.println("SOUTH 버튼 클릭됨");
			}
        }
    }
    
    // addActionListener() 호출하여 리스너 연결
    btnCenter.addActionListener(btnListener);
	btnEast.addActionListener(btnListener);
	btnWest.addActionListener(btnListener);
	btnNorth.addActionListener(btnListener);
	btnSouth.addActionListener(btnListener);  
}
```

<br>

> 패널 - JPanel

컴포넌트를 부착하는 컨테이너

주로 프레임에 패널을 부착한 후, 패널에 컴포넌트를 부착하여 사용

**setLayout()** 메서드를 사용해서 레이아웃 변경

기본 레이아웃 FlowLayout : 좌→우, 상→하 방향으로 배치

창 크기가 변경되면 컴포넌트 위치가 변경되지만, 크기는 유지됨

```java
JPanel p = new JPanel();
getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT)); // 우→좌 방향으로 배치
getContentPane().add(p);
p.setLayout(new BorderLayout(10, 10)); // 영역 사이 간격 10 설정

JButton btn = new JButton("Button");
p.add(btn);
```

<br>

> 텍스트 - **JTextField, JTextArea, JLabel**

JTextField : 한 줄 입력 컴포넌트

JTextArea : 여러 줄 입력 컴포넌트

JLabel : 텍스트 표시 컴포넌트 (입력 불가)

```java
JLabel label = new JLabel("내용");
JTextArea ta = new JTextArea(행 크기, 열 크기);
JTextField tf = new JTextField(열 크기);
```

```java
JTextField tf;
JTextArea ta;
//----------------------------------------------------------------
public void showFrame(){
    ta = new JTextArea(행, 열);  
	tf = new JTextField();
    JButton btnSend = new JButton("전송");
    // → add() 부착하기
    
    ta.setEditable(false); // 편집 불가 설정 
    
    // JButton 이벤트 처리
    btnSend.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			sendText();
		}
	});
    // JTextField 이벤트 처리
    tf.addActionListener(new ActionListener() {
        @Override
		public void actionPerformed(ActionEvent e) {
			sendText();
		}
	});
}

public void sendText() {
	// JTextField에 입력된 텍스트 가져오기
	String msg = tf.getText() + "\n";
	
	// 입력된 텍스트를 JTextArea에 출력하기
	// → 기존 텍스트 유지, 새로 입력된 텍스트 출력
	ta.setText(ta.getText() + msg);
	
	// 입력된 텍스트 삭제(초기화)
	tf.setText("");
	
	// 텍스트필드에 커서
	tf.requestFocus();
}
```

<br>

> 레이아웃 - AbsoluteLayout

구성요소를 자유자재로 배치 가능한 레이아웃

setLayout() 메서드 파라미터 값 **null**으로 설정

요소 생성 후 해당 요소의 setBounds() 메서드 호출 → 배치 좌표, 크기 설정 필수

```java
JPanel pCenter = new JPanel();
getContentPane().add(pCenter, BorderLayout.CENTER);
pCenter.setLayout(null); // AbsoluteLayout 으로 설정

JButton btn = new JButton("Button");
btn.setBounds(x, y, width, height); // 좌표, 크기 지정
pCenter.add(btn);
```

<br>

> 레이아웃 - GridLayout

컴포넌트를 격자(표) 형태로 좌→우, 상→하 배치

창 크기가 변경되면 컴포넌트 크기가 변경, 위치는 고정

```java
JPanel p = new JPanel();
p.setLayout(new GridLayout(행 크기, 열 크기, 수평간격, 수직간격));
```

<br>

> 레이아웃 - CardLayout

컨테이너를 각각의 카드로 생성하여 중첩 → 한 번에 하나의 카드만 표시

```java
// 현재 컨테이너 객체(JFrame) 얻어오기
// (JFrame 클래스를 상속받지 않고 인스턴스를 생성했을 경우 
//  →JFrame 타입 변수 = Container 타입 변수)
Container container = getContentPane();

CardLayout cardLayout = new CardLayout();
JPanel pCenter = new JPanel();
pCenter.setLayout(cardLayout);
add(pCenter, BorderLayout.CENTER);

JButton btn1 = new JButton("버튼1");
JButton btn2 = new JButton("버튼2");
JButton btn3 = new JButton("버튼3");

// JPanel(CardLayout) 객체에 버튼 추가
pCenter.add(btn1);
pCenter.add(btn2);
pCenter.add(btn3);

//-------------------------------------------------------

JPanel pSouth = new JPanel(new GridLayout(1, 2));
add(pSouth, BorderLayout.SOUTH);

JButton btnPrev = new JButton("이전");
JButton btnNext = new JButton("다음");
pSouth.add(btnPrev); 
pSouth.add(btnNext);  

btnPrev.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이전 카드 표시(표시할 컨테이너 → pCenter)
		cardLayout.previous(pCenter);
	}
});
btnNext.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		// 다음 카드 표시(표시할 컨테이너 → pCenter)
			cardLayout.next(pCenter);
		}
	});
}
```

<br>

> 스크롤 - JScrollPane

 JScrollPane 클래스 인스턴스 생성 → 컴포넌트를 JScrollPane 객체에 추가

```java
JTextArea ta = new JTextArea(행 크기, 열 크기);
JScrollPane scrollPane = new JScrollPane(ta);
add(scrollPane);
```

<br>

> 탭 - JTabbedPane

JTabbedPane 객체 생성 → 프레임에 부착

JTabbedPane.XXX 상수를 사용하여 탭 위치 지정

각 탭에 컨테이너를 부착하여 탭 선택 시 해당 컨테이너를 화면에 표시

```java
JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
add(tabbedPane, BorderLayout.CENTER);

JPanel p1 = new JPanel(); // 탭에 부착할 JPanel 객체 생성
JButton btn1 = new JButton("버튼1"); // 패널에 부착할 컴포넌트 생성
p1.add(btn1); // 패널에 컴포넌트 부착
tabbedPane.add(p1, "탭1"); // 탭에 패널 부착

JPanel p2 = new JPanel();
JButton btn2 = new JButton("버튼2");
p2.add(btn2);
tabbedPane.add(p2, "탭2");
```

<br>

> 체크박스 - JCheckBox

생성자에 표시할 텍스트와 체크 여부 전달 가능

```java
JCheckBox cb = new JCheckBox("체크박스", true); // true → 체크
JCheckBox cb = new JCheckBox("체크박스", false); // false → 미체크(기본값) 
//-------------------------------------------------------------------
ActionListener cbListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // ActionEvent e 변수에 JCheckBox 객체가 업캐스팅되어 전달됨
        // 업캐스팅 시 참조영역 축소로 체크박스 기능 사용 불가
        // → JCheckBox 타입으로 다운캐스팅 필요
        JCheckBox cb = (JCheckBox)e.getSource();
        
        System.out.println(cb.getText()); // 체크박스의 텍스트 리턴
        System.out.println(cb.isSelected()); // 선택시 true, 해제시 false 리턴
        
        cb.setSelected(true); // 체크 설정
        cb.setSelected(false); // 체크 설정 해제
	}
};
```

<br>

> 라디오버튼 - JRadioButton

체크박스와 동일한 형태로 동작하므로 다중 선택됨

단일 선택 → 그룹화 필요 → **ButtonGroup** 객체 생성 → JRadioButton 객체 추가 

```java
JRadioButton rb = new JRadioButton("라디오버튼", true); // true → 체크
JRadioButton rb = new JRadioButton("라디오버튼", false); // false → 미체크(기본값)

// 라디오버튼 그룹화
ButtonGroup rbGroup = new ButtonGroup();
rbGroup.add(rb1);
rbGroup.add(rb2);
//-------------------------------------------------------------------
ActionListener rbListener = new ActionListener() {
	@Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton rb = (JRadioButton)e.getSource();
        
        System.out.println(cb.getText());
        System.out.println(cb.isSelected());
        
        rb.setSelected(true); // 체크 
        rbGroup.clearSelection(); // 체크 해제  
    }
};
```

<br>

> 콤보박스 - JComboBox

특정 목록을 선택할 수 있는 풀다운 메뉴 컴포넌트

목록으로 표시할 데이터를 배열이나 컬렉션 객체로 생성 후 **DefaultComboBoxModel** 객체로 관리

```java
JComboBox<String> comboBox = new JComboBox<String>();
add(comboBox);

// 1) 배열 사용 → 데이터 추가
String[] items = {"나타낼", "항목의", "배열"}; // 데이터 배열 생성

DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(items); // 배열 전달
comboBox.setModel(comboBoxModel);

comboBox.setModel(new DefaultComboBoxModel<String>(items));

// 2) Vector 객체 사용 → 데이터 추가
Vector<String> items = new Vector<String>();
items.add("데이터");
items.add("추가");

comboBox.setModel(new DefaultComboBoxModel<String>(items));
//-------------------------------------------------------
comboBox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(comboBox.getSelectedIndex()); // 선택된 항목 인덱스 리턴
        System.out.println(comboBox.getSelectedItem()); // 선택된 항목 데이터 리턴
    }
});
```

<br>

