package com.example.edu.mybind;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Binder binder;

    private BackgroundMusicWithBindService mServiceBinder;
    private ServiceConnection myConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder binder) {
            mServiceBinder=((BackgroundMusicWithBindService.MyBinder) binder).getService();
        }
        public void onServiceDisconnected(ComponentName className) { mServiceBinder = null; }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = new Intent(this, BackgroundMusicWithBindService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
        Button button= findViewById(R.id.play);
        button.setOnClickListener(this);
        Button button1=findViewById(R.id.button5);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                mServiceBinder.play();
                break;
            case R.id.button5:
                mServiceBinder.stop();
                break;
        }


    }
}
