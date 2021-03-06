package org.androidtown.signalapplication.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import org.androidtown.signalapplication.R;

import io.realm.Realm;

public class IntroActivity extends AppCompatActivity {

    private Handler handler;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Realm.init(this);

        //Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);

        init();
        handler.postDelayed(runnable, 1000);
    }

    public void  init() {
        handler = new Handler();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();;
        handler.removeCallbacks(runnable);
    }
}
