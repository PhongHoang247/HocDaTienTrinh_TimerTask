package com.phong.hocdatientrinh_timertask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView txtTimer, txtBackground;
    //Tạo đa tiến trình hẹn giờ:
    TimerTask timerTask;//tạo đa tiến trình
    Timer timer;//kích hoạt tiến trình timerTask

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aaa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        txtTimer = findViewById(R.id.txtTimer);
        txtBackground = findViewById(R.id.txtBackground);
        final Random random = new Random();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {//update giao diện đc
                    @Override
                    public void run() {
                        Calendar calendar = Calendar.getInstance();//trả về ngày giờ tháng năm hiện tại
                        String value = sdf.format(calendar.getTime());//lấy ngày giờ tháng năm
                        txtTimer.setText(value);

                        int alpha = 225;
                        int red = random.nextInt(256);
                        int green = random.nextInt(256);
                        int blue = random.nextInt(256);
                        int color = Color.argb(alpha,red,green,blue);
                        txtBackground.setBackgroundColor(color);
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask,0,1000);
    }
}
