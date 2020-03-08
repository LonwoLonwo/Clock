package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    public static final int DELAY_MILLIS = 250;
    private SimpleDateFormat mTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private TextView mTextView;
    private Runnable mTickRoutine = new Runnable() {
        @Override
        public void run() {
            mTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
            mTextView.setText(mTimeFormat.format(Calendar.getInstance().getTime()));//эта строка будет устанавливать отформатированное время в наше View
            mHandler.postDelayed(this, DELAY_MILLIS);//здесь указывается промежуток времени, в который Handler должен производить проверку состояния. указывается интервал в милисекундах, не более секунды
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.view_time);
        mTickRoutine.run();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mTickRoutine);
        mTextView = null;
    }
}
