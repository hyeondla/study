package com.example.and0805_activity_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Activity 액티비티
        - 안드로이드 화면 구성 단위
        - 하나의 어플리케이션은 최소 하나의 액티비티를 가짐
        - 액티비티 내의 디자인 요소를 표현하기 위해 레이아웃 파일(.xml)을 사용하여 표현
          레이아웃 파일 없이 자바 코드만으로도 디자인 가능
        - 액티비티 역할을 수행하는 클래스는 반드시 Activity 클래스를 상속받아야함
        - 기본 화면 표시 레이아웃은 액티비티 클래스의 onCreate() 내에서 setContentView() 메서드 호출
          -> 표시할 레이아웃 파일의 아이디 값을 지정하여 표시
        */

//        Button btnNewActivity = findViewById(R.id.btnNewActivity);
//
//        btnNewActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "버튼 클릭", Toast.LENGTH_SHORT).show();
//            }
//        });



    }

    // 레이아웃에서 onClick 속성으로 직접 이벤트 대상 메서드 호출
    // 반드시 View 타입 객체를 파라미터로 전달해야 함
    public void newActivity(View v) {
//        Toast.makeText(MainActivity.this, "버튼 클릭", Toast.LENGTH_SHORT).show();

        // 새로운 액티비티 지정 -> 실행
        // Intent 객체 생성
        // -> 파라미터로 현재 액티비티 객체와 새 액티비티 클래스 파일 전달
        //    -> 현재 액티비티 객체 지정 방법
        //        1) getApplicationContent() 메서드 호출
        //        2) 현재 객체를 의미하는 키워드 this -> 리스너 구현체에서 사용 불가
        //                                            -> 액티비티클래스명.this 지정
//        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//        Intent intent = new Intent(this, SecondActivity.class);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        // startActivity() 호출 -> 새 액티비티 실행
        // 파라미터로 Intent 객체 전달
        startActivity(intent);

    }

    public void newActivity2(View view) {
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        // 새 액티비티 실행 -> AndroidManifests.xml 파일 내에서
        // 새로 실행할 액티비티 클래스를 activity 태그로 등록
        startActivity(intent);
    }
}