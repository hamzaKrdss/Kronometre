package com.legionhamz.kronometre;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;


public class MainActivity extends AppCompatActivity {
    Button playPauseBtn, resetBtn;
    Chronometer time_txt;

    private int timeControl = 0;
    private boolean durumKontrol = false;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPauseBtn = findViewById(R.id.play_pause_btn);
        resetBtn = findViewById(R.id.reset_btn);
        time_txt = findViewById(R.id.time_txt);

    }

    public void startStopClick(View view)
    {
        if (durumKontrol == false)
        {
            playPauseBtn.setText("Durdur");
            playPauseBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_pause_24, 0, 0, 0);

            time_txt.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            time_txt.start();

            durumKontrol = true;
        }
        else if(durumKontrol == true)
        {
            playPauseBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_play_arrow_24, 0, 0, 0);
            playPauseBtn.setText("Devam");

            time_txt.stop();
            pauseOffset = SystemClock.elapsedRealtime() - time_txt.getBase();
            durumKontrol = false;
        }
    }

    public void resetClick(View view)
    {
        time_txt.stop();
        time_txt.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        durumKontrol = false;

        playPauseBtn.setText("Başlat");
        playPauseBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_play_arrow_24, 0, 0, 0);
    }

}

