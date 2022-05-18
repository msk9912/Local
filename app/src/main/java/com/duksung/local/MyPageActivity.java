package com.duksung.local;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

//마이페이지
public class MyPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        //설정 버튼 눌렀을 때
        FloatingActionButton set_btn = (FloatingActionButton) findViewById(R.id.set_btn);
        set_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MyPageActivity.this, SettingsActivity.class);
                startActivity(intent);

            }
        });
    }
}
