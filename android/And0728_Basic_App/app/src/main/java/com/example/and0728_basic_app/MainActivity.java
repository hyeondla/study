package com.example.and0728_basic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃의 Button 위젯을 자바의 Button 타입 객체와 연결
        Button btn = findViewById(R.id.btn);

        // 버튼 클릭 리스너 연결 : OnClickListener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼 클릭됨", Toast.LENGTH_SHORT).show();
            }
        });


    }
}