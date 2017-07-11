package com.abhimanyusharma.hewlett_packard_training;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service implements MediaPlayer.OnCompletionListener
{  MediaPlayer mplayer ;

    @Override
    public void onCreate()
    {	super.onCreate();
        mplayer = MediaPlayer.create(this, R.raw.kk);
        mplayer.setOnCompletionListener(this);
    }//end of onCreate();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {   if( mplayer.isPlaying() == false)
    {   mplayer.start();
        Toast.makeText(this, "Music Play started", Toast.LENGTH_LONG).show();
    }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {	super.onDestroy();
        if(mplayer.isPlaying() == true)
        {	mplayer.stop();
        }
        Toast.makeText(this, "Music Stoped", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCompletion(MediaPlayer arg0)
    {	stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent)
    {  return null;
    }
}