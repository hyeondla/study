package com.example.and0730_basic_widget_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbAndroid = findViewById(R.id.cbAndroid);
        CheckBox cbIPhone = findViewById(R.id.cbIPhone);
        CheckBox cbWindows = findViewById(R.id.cbWindows);
        CheckBox cbAll = findViewById(R.id.cbAll);
        Button btnOk = findViewById(R.id.btnOk);
        TextView tvCheck = findViewById(R.id.tvCheck);


//        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // 체크박스의 체크 상태가 변경될 경우 자동 호출됨
//                if(isChecked) {
//                    tvCheck.setText("안드로이드 - 체크됨");
//                } else {
//                    tvCheck.setText("안드로이드 - 체크해제됨");
//                }
//            }
//        });

        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox cb = (CheckBox) buttonView; // 다운 캐스팅
                tvCheck.setText(cb.getText() + " - " + cb.isChecked());

                if(cb.getId() == R.id.cbAll) {
////                    Toast.makeText(MainActivity.this, "전체 선택", Toast.LENGTH_SHORT).show();

//                    if(isChecked) { // 전체 선택 체크박스가 체크됐을 때
//                        cbAndroid.setChecked(true);
//                        cbIPhone.setChecked(true);
//                        cbWindows.setChecked(true);
//                    } else {
//                        cbAndroid.setChecked(false);
//                        cbIPhone.setChecked(false);
//                        cbWindows.setChecked(false);
//                    }

                    cbAndroid.setChecked(isChecked);
                    cbIPhone.setChecked(isChecked);
                    cbWindows.setChecked(isChecked);
                }


            }
        };
        cbAndroid.setOnCheckedChangeListener(onCheckedChangeListener);
        cbIPhone.setOnCheckedChangeListener(onCheckedChangeListener);
        cbWindows.setOnCheckedChangeListener(onCheckedChangeListener);
        cbAll.setOnCheckedChangeListener(onCheckedChangeListener);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String items = "";
                if(cbAndroid.isChecked()) {
                    items += cbAndroid.getText() + "/";
                }
                if(cbIPhone.isChecked()) {
                    items += cbIPhone.getText() + "/";
                }
                if(cbWindows.isChecked()) {
                    items += cbWindows.getText() + "/";
                }

                Toast.makeText(MainActivity.this, items, Toast.LENGTH_SHORT).show();
            }
        });
    }
}