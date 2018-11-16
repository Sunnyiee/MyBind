package com.example.edu.mybind;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class BackgroundMusicWithBindService extends Service {
    public BackgroundMusicWithBindService() {
    }

    @Override
    public IBinder onBind(Intent arg0) {return new MyBinder();}
    public class MyBinder extends Binder {
        BackgroundMusicWithBindService getService() {
            return BackgroundMusicWithBindService.this;
        }
    }
    MediaPlayer mPlayer;
    public void play() {
        mPlayer = MediaPlayer.create(this, R.raw.thunder_rain);
        mPlayer.setLooping(true);
        mPlayer.setVolume(100,100);
        mPlayer.start();
    }
    public void stop(){
        mPlayer.stop();
        mPlayer.release();
    }
}
