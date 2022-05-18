package com.duksung.local;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

//업로드시 공개범위 설정
public class RangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);

        //처음엔 사운드태그뷰와 체크버튼 비활성화
        View st_view=findViewById(R.id.soundtag_view);
        CheckBox st_check =findViewById(R.id.soundtag); //사운드태그체크버튼
        st_view.setVisibility(View.GONE);
        st_check.setEnabled(false);

        //처음에 게시물뷰 비활성화
        View p_view=findViewById(R.id.post_view);
        CheckBox p_check=findViewById(R.id.post);//게시물체크버튼
        p_view.setVisibility(View.GONE);

        //게시물 체크시 화면 보이도록
        p_check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                p_view.setVisibility(View.VISIBLE);
            }
        });

//        //사운드태그신호받으면 비활성화 푸는 코드 추가하기
//        st_check.setEnabled(true);

        //특정친구선택시코드



    }


}
