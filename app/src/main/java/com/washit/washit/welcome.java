package com.washit.washit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.washit.washit.accountConnection.LoginActivity;

public class welcome extends AppCompatActivity {
private TextView t;
private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t=(TextView)findViewById(R.id.t);
        iv=(ImageView)findViewById(R.id.iv);
        Animation a= AnimationUtils.loadAnimation(this,R.anim.myanim);
        t.startAnimation(a);
        iv.startAnimation(a);
        final Intent intent=new Intent(this,LoginActivity.class);
        Thread t=new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        t.start();
    }
}
