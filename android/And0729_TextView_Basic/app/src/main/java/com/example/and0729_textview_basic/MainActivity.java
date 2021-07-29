package com.example.and0729_textview_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);

        tv1.setText("자바 코드로 변경한 텍스트");
        tv1.setTextColor(Color.BLUE);

        tv2.setTextSize(40);

        tv3.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);

    }
}