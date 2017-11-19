package org.androidtown.signalapplication.Activities;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.androidtown.signalapplication.R;
import org.androidtown.signalapplication.RegisterRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class JoinActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        final EditText registerMail = (EditText) findViewById(R.id.register_mail);
        final EditText registerPw = (EditText) findViewById(R.id.register_pw);
        final EditText registerPwCon = (EditText) findViewById(R.id.register_pw_con);
        final EditText registerName = (EditText) findViewById(R.id.register_name);
        final EditText registerJob = (EditText) findViewById(R.id.register_job);

        ImageButton profileImg = (ImageButton) findViewById(R.id.add_profile_image_button);
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = registerMail.getText().toString();
                String userPW = registerPw.getText().toString();
                String userName = registerName.getText().toString();
                String userJob = registerJob.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                builder.setMessage("회원가입에 성공하였습니다")
                                        .setPositiveButton("확인", null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                                JoinActivity.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                builder.setMessage("회원가입에 실패하였습니다")
                                        .setNegativeButton("다시 시도", null)
                                        .create()
                                        .show();
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(userID, userPW, userName, userJob, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(registerRequest);

            }
        });

    }


    // id 중복 확인 (mail)
    // pw 적합 확인
    // image 원형 크롭
    // registerButton 누르면 등록 & 로그인 페이지로 (ID 값 가져오기)


}
