package org.androidtown.signalapplication.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.androidtown.signalapplication.CircleImageView;
import org.androidtown.signalapplication.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    final static int REQ_CODE_SELECT_IMAGE = 100;

    LinearLayout mRegistLayout;
    CircleImageView mUserProfileImg;
    EditText mUserID, mUserPW, mUserPWCon, mUserName, mUserJob, mUserPhone;
    Button mRegisterButton;

    String mCurrentImgPath;
    Uri mImgUri;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {

        mUserID = (EditText) findViewById(R.id.user_id);
        mUserPW = (EditText) findViewById(R.id.user_pw);
        mUserPWCon = (EditText) findViewById(R.id.user_pw_con);
        mUserName = (EditText) findViewById(R.id.user_name);
        mUserJob = (EditText) findViewById(R.id.user_occu);
        mUserPhone = (EditText) findViewById(R.id.user_phone);

        mUserProfileImg = (CircleImageView) findViewById(R.id.add_profile_img);
        mRegistLayout = (LinearLayout) findViewById(R.id.register_layout);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        mUserProfileImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_profile_img, getApplicationContext().getTheme()));

        mUserProfileImg.setOnClickListener(this);
        mRegistLayout.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        Toast.makeText(getBaseContext(), "resultCode : "+resultCode, Toast.LENGTH_SHORT).show();

        if(requestCode == REQ_CODE_SELECT_IMAGE){
            if(resultCode==Activity.RESULT_OK){
                //데이터 받기
                try{
                    mCurrentImgPath = data.getStringExtra("imgUri");
                    mImgUri = Uri.parse(mCurrentImgPath);
                    mUserProfileImg.setImageURI(mImgUri);

                }

                catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.add_profile_img:
                // img click -> 이미지 처리 액티비티 -> 이미지 받아오기 > 이미지뷰에 보여주기 > multipart-formdata로 서버 전송
                Intent intent = new Intent(RegisterActivity.this, ImageActivity.class);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
                break;

            case R.id.register_layout:
                // keyboard
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(mUserID.getWindowToken(), 0);
                break;

            case R.id.register_button:
                // send server & get response
                break;

        }

    }
}
