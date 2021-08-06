package com.example.and0805_two_way_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

    }

    public void newActivity(View view) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());

        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);

        // startActivityForResult 호출 -> 새 액티비티로부터 응답 데이터를 전달받음
        // requestCode는 요청을 받는 새 액티비티에서 여러 개의 요청이 있을 때
        // 각 요청을 구분하는 용도로 사용
        startActivityForResult(intent, 0);

    }

    // Callback Method -> SecondActivity의 응답 데이터를 전달 받음
    // onActivityResult() 오버라이딩
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // SecondActivity로부터 전달받은 Intent 객체 가져오기
        // -> onActivityResult() 메서드 파라미터로 전달받은 Intent 객체 사용

        // 여러개의 액티비티를 전환하는 경우
        // requestCode 값에 따라 응답 액티비티 구분
        if(resultCode == RESULT_OK) { // 정상 응답
            // 전달받은 Intent 객체(data)에 저장된 데이터 가져오기
            int result = data.getIntExtra("result", 0);
            Toast.makeText(this, "계산결과 : " + result, Toast.LENGTH_SHORT).show();
        } else { // 비정상 응답
            Toast.makeText(this, "응답 오류 발생", Toast.LENGTH_SHORT).show();
        }


    }
}