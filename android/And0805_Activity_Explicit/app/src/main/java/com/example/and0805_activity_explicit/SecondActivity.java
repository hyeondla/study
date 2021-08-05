package com.example.and0805_activity_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvNum1 = findViewById(R.id.tvNum1);
        TextView tvNum2 = findViewById(R.id.tvNum2);

        // 새 액티비티가 실행될 때 onCreate() 호출됨
        // -> 전달받은 Intent 객체 가져올 수 있음
        Intent intent = getIntent(); // MainActivity가 전달한 Intent 객체 리턴받기

        // 리턴받은 Intent 객체의 getXXXExtra() 호출, XXX: 데이터 타입 -> 저장된 데이터 가져옴
        // 배열도 가능, getIntArrayExtra
        // 기본 데이터타입의 경우 파라메터에 속성명, 기본값 설정 전달
        int num1 = intent.getIntExtra("num1", 0); // 기본값 0
        int num2 = intent.getIntExtra("num2", 0); // 기본값 0

        tvNum1.setText("전달받은 숫자 1 : " + num1);
        tvNum2.setText("전달받은 숫자 2 : " + num2);

    }

    public void finish(View view){
        finish();
    }

}