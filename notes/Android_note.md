> 위젯 Widget

안드로이드 화면을 구성하는 컴포넌트

<br>

> 레이아웃 Layout

안드로이드 화면을 구성하는 요소들의 배치를 결정

**LinearLayout** : View를 수평/수직 방향으로 배치할 수 있는 레이아웃

android:orientation="**vertical**"  → 수직 배치

android:orientation="**horizontal**" → 수평 배치 

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >
	
    <TextView 
      ...          
    />
    
    <Button
   	  ...        
	/>
    
</LinearLayout>
```

```java
public class MainActivity extends AppCompatActivity {
    // -------------------------------------------------------
    // 멤버 변수 선언 가능 → onCreate 외 다른 메서드에서도 접근 가능
    // -------------------------------------------------------
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		// 레이아웃 파일(activity_main.xml)을 현재 액티비티에 포함시켜 표시
		setContentView(R.layout.activity_main); // 주석처리 시 레이아웃 파일이 표시되지 않음
        
    }
}
```

<br>

> 버튼

```java
<Button
	android:layout_width="match_parent" 
    android:layout_height="wrap_content"
	android:id="@+id/btn"
    android:text="버튼" />
```


```java
// android.widget 패키지 import 필수
// Button 타입 선언 → findViewById(R.id.위젯에 지정한 id) 
Button btn = findViewById(R.id.btn); 

// -------------------------------- 5단계 ------------------------------------
// Button 객체에 OnClickListener 인터페이스 연결 → setOnClickListener() 메서드 호출
btn.setOnClickListener(new View.OnClickListener() { 
	
    @Override
    public void onClick(View v) { // 버튼 클릭 시 onClick() 메서드가 자동으로 호출됨
    	// 수행할 작업
		Toast.makeText(MainActivity.this, "버튼 클릭됨", Toast.LENGTH_SHORT).show();
    }
});

// -------------------------------- 4단계 ------------------------------------
View.OnClickListener onClickListener = new View.OnClickListener() {
	@Override
    public void onClick(View v) {
    	// 버튼 구별 → View 타입 객체 v의 getId() 메서드 호출
        // → 이벤트 동작이 일어난 객체의 아이디 가져옴
		switch(v.getId()) {
        	case R.id.btnAdd : 
            	calc('+');
				break;
			case R.id.btnSub :
				calc('-');
                break;
        }
	}
};
// 각 버튼 객체에 리스너 연결
btnAdd.setOnClickListener(onClickListener);
btnSub.setOnClickListener(onClickListener);
```

<br>

> 텍스트

```xml
<TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/tv" 
    android:text="표시할 내용"
    android:textSize="30sp" <!-- 글자 크기 설정 -->
    android:textColor="#FF0000" <!-- 글자 색상 설정 -->
	/>

<EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/et"
    android:hint="표시할 내용" <!-- placeholder 역할 -->
    android:layout_marginBottom="20dp"
    android:singleLine="true"
	/>
```

```java
TextView tv = findViewById(R.id.tv);
EditText et = findViewById(R.id.et);
// onCreate() 메서드 내에서 EditText 위젯 값을 가져올 경우
// → 앱이 실행되자마자 읽어옴 → 널스트링("") → 변환 작업 등 → 데이터가 없으므로 예외 발생
// → 이벤트 리스너 구현체 내부에서 수행해야 함
btn.setOnClickListener(new View.OnClickListener() {
    @Override
	public void onClick(View v) {
		int num = Integer.parseInt(et.getText().toString());
        if(num == 0) {
        	Toast.makeText(MainActivity.this, "0 입력 불가능", Toast.LENGTH_SHORT).show();
            et.requestFocus(); // 커서 요청
            return; // 작업 중단 후 메서드 종료
        }
        
        // Toast 메세지로 출력시 정수형 데이터는 문자열로 변환하여 전달해야함
        Toast.makeText(MainActivity.this, num + "", Toast.LENGTH_SHORT).show();
        
        // setText() 메서드 파라미터에 정수 데이터 전달 시 ID 값으로 취급 됨 → 예외 발생
        // → 문자열로 변환하여 전달해야함
        tv.setText("" + num);
    }
}
```

<br>

> 체크박스

```xml
<CheckBox
	android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:id="@+id/check"
	android:text="체크"
	/>
```

```java
CheckBox cb1 = findViewById(R.id.cb1);
CheckBox cb2 = findViewById(R.id.cb2);
CheckBox cbAll = findViewById(R.id.cbAll);

// 체크박스 이벤트 처리

// -------------------------------- 단일 감지 ------------------------------------
cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// 대상 체크박스의 체크 상태가 변경될 경우 자동으로 호출됨
        // → 파라미터로 전달되는 boolean isChecked 변수를 사용하여 체크 여부 판별
		if(isChecked) { // 체크
			...
		} else { // 체크 해제
			...
		}
	}
});

// -------------------------------- 4단계 ------------------------------------
CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
	@Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    	// buttonView 변수에 체크 상태가 변한 객체가 전달됨
        // CheckBox 타입으로 다운캐스팅 필요
        CheckBox cb = (CheckBox) buttonView;

        // getText() 메서드 → 체크박스의 text 속성값을 가져옴
        // isChecked() 메서드 / 파라미터 isChecked → 체크 여부 판별
        tvCheck.setText(cb.getText() + " - " + isChecked);

        if(cb.getId() == R.id.cbAll) { // 전체 선택 체크박스일 경우
			cb1.setChecked(isChecked);
	        cb2.setChecked(isChecked);
		}
	}
};
cb1.setOnCheckedChangeListener(onCheckedChangeListener);
cb2.setOnCheckedChangeListener(onCheckedChangeListener);
cbAll.setOnCheckedChangeListener(onCheckedChangeListener);

```

<br>

> 라디오 버튼

```xml
<!-- RadioGroup 위젯으로 감싸서 그룹화 -->
<RadioGroup
	android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:id="@+id/rGroup">

	<RadioButton
    	android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/rb1"
        android:text="선택지1"
        />
	<RadioButton
    	android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/rb2"
        android:text="선택지2"
        />
    
</RadioGroup>
```

```java

```

