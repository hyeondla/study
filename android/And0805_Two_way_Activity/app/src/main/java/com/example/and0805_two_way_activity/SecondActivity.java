package com.example.and0805_two_way_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvNum1 = findViewById(R.id.tvNum1);
        TextView tvNum2 = findViewById(R.id.tvNum2);

        Intent intent = getIntent();

        num1 = intent.getIntExtra("num1", 0); // 기본값 0
        num2 = intent.getIntExtra("num2", 0); // 기본값 0

        tvNum1.setText("전달받은 숫자 1 : " + num1);
        tvNum2.setText("전달받은 숫자 2 : " + num2);

    }

    public void finish(View view){
        // 돌아가기 버튼 클릭 시 기존 액티비티로 데이터 전달

        // Intent 객체 생성
        Intent returnIntent = new Intent(SecondActivity.this, MainActivity.class);

        // Intent 객체에 리턴할 데이터 저장
        returnIntent.putExtra("result", num1 + num2);

        // setResult() 호출 -> 응답코드와 응답데이터(리턴값) 저장
        // 응답코드 : 정상 여부 판별 (임의 또는 상수 사용)
        setResult(RESULT_OK, returnIntent);

        // 현재 액티비티 종료 후 돌아가기
        finish();
        // => 자동으로 원래 액티비티의 onActivityResult() 메서드 자동 호출됨
        //     메서드 호출이 종료될 때 자동으로 호출되는 메서드 = 콜백 메서드

    }

}