package org.androidtown.signalapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.androidtown.signalapplication.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText mUserID = (EditText) findViewById(R.id.user_id);
        EditText mUserPW = (EditText) findViewById(R.id.user_pw);
        EditText mUserPWCon = (EditText) findViewById(R.id.user_pw_con);
        EditText mUserName = (EditText) findViewById(R.id.user_name);
        EditText mUserJob = (EditText) findViewById(R.id.user_occu);
        EditText mUserPhone = (EditText) findViewById(R.id.user_phone);

        // img click -> image crop
        ImageView mUserProfileImg = (ImageView) findViewById(R.id.add_profile_img);

        // keyboard
        LinearLayout mRegistLayout = (LinearLayout) findViewById(R.id.register_layout);

        // send server & get response
        Button mRegisterButton = (Button) findViewById(R.id.register_button);


    }
}
