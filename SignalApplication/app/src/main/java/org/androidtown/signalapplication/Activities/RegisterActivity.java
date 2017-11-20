package org.androidtown.signalapplication.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
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

import org.androidtown.signalapplication.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    final int REQ_CODE_SELECT_IMAGE = 100;
    ImageView mUserProfileImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText mUserID = (EditText) findViewById(R.id.user_id);
        EditText mUserPW = (EditText) findViewById(R.id.user_pw);
        EditText mUserPWCon = (EditText) findViewById(R.id.user_pw_con);
        EditText mUserName = (EditText) findViewById(R.id.user_name);
        EditText mUserJob = (EditText) findViewById(R.id.user_occu);
        EditText mUserPhone = (EditText) findViewById(R.id.user_phone);

        // img click -> image round crop -> multipart/form-data
        mUserProfileImg = (ImageView) findViewById(R.id.add_profile_img);
        mUserProfileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.add_profile_img:
                        Intent intent = new Intent(RegisterActivity.this, ImageActivity.class);
                        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
                        break;
                    default:
                        break;
                }

            }
        });


        // keyboard
        LinearLayout mRegistLayout = (LinearLayout) findViewById(R.id.register_layout);
        mRegistLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(mUserID.getWindowToken(), 0);
            }
        });

        // send server & get response
        Button mRegisterButton = (Button) findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Toast.makeText(getBaseContext(), "resultCode : "+resultCode, Toast.LENGTH_SHORT).show();

        if(requestCode == REQ_CODE_SELECT_IMAGE){
            if(resultCode==Activity.RESULT_OK){
                //데이터 받기
                try{
                    //Uri에서 이미지 이름 얻어오기
                    //String imgName = getImageNametoUri(data.getData());

                    //이미지를 비트맵으로 받아오기
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());

                    //bitmap을 imageview에
                    mUserProfileImg.setImageBitmap(bitmap);

                    //Toast.makeText(getBaseContext(), "imgName : "+imgName, Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }




}
