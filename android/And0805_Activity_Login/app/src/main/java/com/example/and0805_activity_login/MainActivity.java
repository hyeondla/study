package com.example.and0805_activity_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etId, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etPassword = findViewById(R.id.etPassword);


    }

    public void login(View view) {
        if(etId.length() == 0) { // 아이디 미입력
            Toast.makeText(this, "아이디 입력 필수", Toast.LENGTH_SHORT).show();
            etId.requestFocus();
        } else if(etPassword.length() == 0) { // 패스워드 미입력
            Toast.makeText(this, "패스워드 입력 필수", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
        } else {
            String id = etId.getText().toString();
            String password = etPassword.getText().toString();

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);

            // Intent 객체에 아이디, 패스워드 값 저장
            intent.putExtra("id", id);
            intent.putExtra("password", password);

            startActivity(intent);

        }
    }

    public void cancel(View view) {
        etId.setText("");
        etPassword.setText("");
        etId.requestFocus();
    }

}