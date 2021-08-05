package com.example.and0805_activity_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        // 버튼 클릭 5단계 -> 리스너 구현체 내에서는 this 사용 불가


    }

    public void newActivity(View view) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        // Intent 객체를 통해 새 액티비티로 입력받은 숫자 전달

        // 입력받은 숫자 가져오기
        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());

        // Intent 객체의 putExtra() 호출 -> 전달할 데이터 저장 (키,값) 형태
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);

        startActivity(intent);

    }
}