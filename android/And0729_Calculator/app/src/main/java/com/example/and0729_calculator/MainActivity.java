package com.example.and0729_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.textResult);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnAdd : // 더하기 버튼일 경우
                        calc('+');
                        break;
                    case R.id.btnSub : // 더하기 버튼일 경우
                        calc('-');
                        break;
                    case R.id.btnMul : // 더하기 버튼일 경우
                        calc('*');
                        break;
                    case R.id.btnDiv : // 더하기 버튼일 경우
                        calc('/');
                        break;
                }
            }
        };
        
        btnAdd.setOnClickListener(onClickListener);
        btnSub.setOnClickListener(onClickListener);
        btnMul.setOnClickListener(onClickListener);
        btnDiv.setOnClickListener(onClickListener);

    }
    private void calc(char op) {
        Integer num1 = Integer.parseInt(edit1.getText().toString());
        Integer num2 = Integer.parseInt(edit2.getText().toString());

        Integer result = 0;
        
        if(op == '+') {
            result = num1 + num2;
        } else if(op == '-') {
            result = num1 - num2;
        } else if(op == '*') {
            result = num1 * num2;
        } else if(op == '/') {
            if(num2 == 0) {
                Toast.makeText(this, "0으로 나눌 수 없음", Toast.LENGTH_SHORT).show();
                edit2.setText("");
                edit2.requestFocus();
                textResult.setText("계산 결과 : 입력 오류");
                return;
            }
            result = num1 / num2;
        }


        textResult.setText("계산 결과 : " + result);




    }


}