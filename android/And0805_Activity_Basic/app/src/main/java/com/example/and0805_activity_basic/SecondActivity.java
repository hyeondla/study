package com.example.and0805_activity_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

// 액티비티 클래스 -> Activity / AppCompatActivity 클래스 상속
public class SecondActivity extends AppCompatActivity {
    // onCreate() 오버라이딩 필수
    // -> 액티비티가 실행되면 가장 먼저 호출됨 (1회)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("두번째 액티비티");

        // 현재 액티비티가 실행될 때 표시할 화면을 표시
        // setContentView() -> 레이아웃 파일 아이디값 파라미터로 전달
        setContentView(R.layout.activity_second);
    }

    public void finish(View v) {
        // 현재 액티비티 종료, 원래 액티비티로 돌아감
        finish();
    }

}