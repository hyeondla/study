package com.example.and0730_pet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        CheckBox cb = findViewById(R.id.cb);
        RadioGroup rGroup = findViewById(R.id.rGroup);
        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        RadioButton rb3 = findViewById(R.id.rb3);
        Button btn = findViewById(R.id.btn);
        Button btnReset = findViewById(R.id.btnReset);
        ImageView iv = findViewById(R.id.iv);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                    iv.setVisibility(View.VISIBLE);
                } else {
                    tv2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                    iv.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, rGroup.getCheckedRadioButtonId() + "", Toast.LENGTH_SHORT).show();
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.rb1: // 강아지 선택
                        iv.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rb2: // 고양이 선택
                        iv.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rb3: // 토끼 선택
                        iv.setImageResource(R.drawable.rabbit);
                        break;
                    case -1 : // 미선택 (default)
                        Toast.makeText(MainActivity.this, "동물을 선택하세요", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(0); // ID값 0 -> 기존 표시된 사진 제거
                cb.setChecked(false); // 체크 해제
                rGroup.clearCheck(); // 라디오버튼 초기화
            }
        });

    }
}