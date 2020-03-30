package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DefaultActivity extends AppCompatActivity {
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);

    private TextView mOutputTextView;
    private Button mWorkButton;
    private Button mClearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        mOutputTextView = findViewById(R.id.view_output);
        mWorkButton = findViewById(R.id.button_work);
        mClearButton = findViewById(R.id.button_clear);

        final String buttonText = mOutputTextView.getText().toString();

        mWorkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mOutputTextView.setText(mDateFormat.format(Calendar.getInstance().getTime()));
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOutputTextView.setText(buttonText);
            }
        });
    }
}
