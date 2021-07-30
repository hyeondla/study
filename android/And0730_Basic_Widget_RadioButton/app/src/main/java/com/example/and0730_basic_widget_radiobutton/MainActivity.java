package com.example.and0730_basic_widget_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rGroup = findViewById(R.id.rGroup);
        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        TextView tvSelectedItem = findViewById(R.id.tvSelectedItem);

//        rb1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvSelectedItem.setText("선택항목 : " + rb1.getText());
//            }
//        });
//        rb2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvSelectedItem.setText("선택항목 : " + rb2.getText());
//            }
//        });

//        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.rb1:
//                        tvSelectedItem.setText("선택항목 : " + rb1.getText());
//                        break;
//                    case R.id.rb2:
//                        tvSelectedItem.setText("선택항목 : " + rb2.getText());
//                        break;
//                }
//            }
//        });

        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.rb1:
                        tvSelectedItem.setText("선택항목 : " + rb1.getText());
                        break;
                    case R.id.rb2:
                        tvSelectedItem.setText("선택항목 : " + rb2.getText());
                        break;
                }
            }
        });

    }
}