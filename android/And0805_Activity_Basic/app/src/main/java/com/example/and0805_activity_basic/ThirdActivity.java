package com.example.and0805_activity_basic;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("세번째 액티비티");
        setContentView(R.layout.activity_third);
    }

    public void finish(View v) {
        // 현재 액티비티 종료, 원래 액티비티로 돌아감
        finish();
    }

}
