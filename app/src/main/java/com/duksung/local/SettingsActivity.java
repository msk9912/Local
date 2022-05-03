package com.duksung.local;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.ArrayList;

import javax.annotation.Nullable;

//마이페이지에 설정버튼 누르면 뜨는 창
public class SettingsActivity extends AppCompatActivity {

    ImageView imageView;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        //로그아웃버튼
        mFirebaseAuth = FirebaseAuth.getInstance();

        Button logout_btn = findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로그아웃 하기
                mFirebaseAuth.signOut();

                Intent intent1 = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        //닉네임수정하기(서버랑 연결+닉네임중복되는지 확인)
        final TextView nick=(TextView)findViewById(R.id.editNick_text); //닉네임텍스트


        //갤러리에서 이미지 가져와기(+서버에 저장은 아직..)
        imageView = (ImageView)findViewById(R.id.editImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }

        });

    }


    //갤러리에서 이미지 가져오기(+서버에 저장은 아직..)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to  없으면 오류나더라..
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    imageView.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
