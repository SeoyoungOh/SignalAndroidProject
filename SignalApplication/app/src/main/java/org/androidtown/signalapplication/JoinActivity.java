package org.androidtown.signalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class JoinActivity extends AppCompatActivity {

    private EditText registerMail, registerPw, registerPwCon, registerName, registerJob;
    private ImageButton profileImg;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        registerMail = (EditText) findViewById(R.id.register_mail);
        registerPw = (EditText) findViewById(R.id.register_pw);
        registerPwCon = (EditText) findViewById(R.id.register_pw_con);
        registerName = (EditText) findViewById(R.id.register_name);
        registerJob = (EditText) findViewById(R.id.register_job);

        profileImg = (ImageButton) findViewById(R.id.add_profile_image_button);

        registerButton = (Button) findViewById(R.id.register_button);

    }

    // id 중복 확인 (mail)
    // pw 적합 확인
    // image 원형 크롭
    // registerButton 누르면 등록 & 로그인 페이지로 (ID 값 가져오기)
}
