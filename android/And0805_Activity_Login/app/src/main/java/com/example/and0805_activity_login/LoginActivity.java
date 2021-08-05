package com.example.and0805_activity_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView tvId, tvPassword;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvId = findViewById(R.id.tvId);
        tvPassword = findViewById(R.id.tvPassword);
        btnReturn = findViewById(R.id.btnReturn);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String password = intent.getStringExtra("password");

        boolean loginResult = login(id, password);

        if(loginResult) {
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show();
            tvId.setText("아이디 : " + id);
            tvPassword.setText("비밀번호 : " + password);
        } else {
            Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show();
            // 현재 액티비티 종료, MainActivity로 돌아가기
            finish();
        }

    }

    private boolean login(String id, String password) {

        boolean loginResult = false;

        // 아이디, 패스워드 판별
        if(id.equals("admin") && password.equals("1234")) {
            loginResult = true;
        }

        return loginResult;

    }


    public void finish(View view) {
        finish();
    }
}