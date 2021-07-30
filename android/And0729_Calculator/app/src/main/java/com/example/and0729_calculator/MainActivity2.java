package com.example.and0729_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit1 = findViewById(R.id.edit1);
        EditText edit2 = findViewById(R.id.edit2);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);

        TextView textResult = findViewById(R.id.textResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1 = Integer.parseInt(edit1.getText().toString());
                Integer num2 = Integer.parseInt(edit2.getText().toString());

                Integer result = num1 + num2;

                textResult.setText("계산 결과 : " + result);
                // 정수 타입 입력 시 오류 -> 아이디 값으로 인식 -> 예외 발생생

               edit1.setText("");
                edit2.setText("");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1 = Integer.parseInt(edit1.getText().toString());
                Integer num2 = Integer.parseInt(edit2.getText().toString());

                Integer result = num1 - num2;

                textResult.setText("계산 결과 : " + result);

                edit1.setText("");
                edit2.setText("");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1 = Integer.parseInt(edit1.getText().toString());
                Integer num2 = Integer.parseInt(edit2.getText().toString());

                Integer result = num1 * num2;

                textResult.setText("계산 결과 : " + result);

                edit1.setText("");
                edit2.setText("");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1 = Integer.parseInt(edit1.getText().toString());
                Integer num2 = Integer.parseInt(edit2.getText().toString());

                // if문으로 예외 처리
//                if(num2 == 0) {
//                    Toast.makeText(MainActivity.this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
//                    edit2.setText("");
//                    edit2.requestFocus();
//                    return; // 메서드 종료
//                }
//                Integer result = num1 / num2;
//                textResult.setText("계산 결과 : " + result);

                // try ~ catch문으로 예외처리
                try {
                    Integer result = num1 / num2;
                    textResult.setText("계산 결과 : " + result);
                } catch (Exception e) {
                    Toast.makeText(MainActivity2.this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    textResult.setText("계산 결과 : 오류 발생");
                    edit2.requestFocus();
                }

                edit1.setText("");
                edit2.setText("");
            }
        });
        

    }
}