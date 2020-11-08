package com.eman.assgiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    private int seconds=0;
    private boolean running;
    private EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        /// her change it !!!!
        if(savedInstanceState !=null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        time=findViewById(R.id.editTextTime);

        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("seconds", seconds);
        bundle.putBoolean("running", running);
    }
    public void StartTimer(View view){
        String s=time.getText().toString();
        seconds=Integer.parseInt(s);
        running = true;
    }

    public void pauseTimer(View view) {
        running = false;
    }

    public void stopTimer(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer(){  // her should study code and
       // final TextView txtViewHourse = (TextView) findViewById(R.id.Testp);
       // final TextView txtView = (TextView) findViewById(R.id.editTextTime2);  // هون للدقائق
       // final TextView txtViewSecond = (TextView) findViewById(R.id.editTextTime3);
        final TextView txtView = (TextView) findViewById(R.id.Testp);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = seconds % 3600 /60;
                int snds = seconds % 60;
                if(hours>=0 && minutes>= 0 && snds>=0) {
                    String time = String.format(Locale.getDefault(),
                            "  %d:%02d:%02d", hours, minutes, snds);
                    txtView.setText(time);

                   if(running && hours>=0 && minutes>= 0 && snds>=0)
                      --seconds;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}