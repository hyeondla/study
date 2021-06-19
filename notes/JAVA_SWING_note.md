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

> 창 구현하기

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

> 컴포넌트(버튼) 만들기

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

1단계 : 리스너 인터페이스를 구현하는 구현체 클래스를 정의하여 이벤트 처리

2단계 : 리스너 인터페이스 대신 어댑터 클래스의 서브클래스를 정의

어댑터 클래스를 상속받아 필요한 메서드만 오버라이딩 가능

3단계 : 구현체 클래스를 내부 클래스 형태로 정의

보통 구현체 클래스는 GUI 클래스 전용으로 사용하는 경우가 대부분이므로 내부클래스로 정의

4단계 : 구현체 클래스를 익명 내부 클래스(Anonymous Inner Class) 형태로 정의

변수 선언 및 인스턴스 생성, 추상메서드 구현까지 한꺼번에 수행

5단계 : 익명 내부 클래스를 임시 객체 형태로 구현하여 사용

1회용 객체로써 한 번 사용 후 제거됨, 다른 컴포넌트에서 사용 불가)