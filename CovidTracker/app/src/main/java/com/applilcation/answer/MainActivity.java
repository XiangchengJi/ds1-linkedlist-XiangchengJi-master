package com.applilcation.answer;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTvDate;
    /**
     * Welcome,Joey U
     */
    private TextView mTvWelcome;
    /**
     * Welcome,Joey U
     */
    private TextView mTvDesc;
    /**
     * Welcome,Joey U
     */
    private TextView mTvTips;

    private Button btn_temperature;
    private Button btn_notepad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_temperature = findViewById(R.id.btn_temperature);
        btn_notepad = findViewById(R.id.btn_notepad);
        mTvDate = (TextView) findViewById(R.id.tv_date);
        mTvWelcome = (TextView) findViewById(R.id.tv_welcome);
        mTvDesc = (TextView) findViewById(R.id.tv_desc);
        mTvTips = (TextView) findViewById(R.id.tv_tips);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String format = simpleDateFormat.format(new Date());
        mTvDate.setText(format);
        String tip = getIntent().getStringExtra("tips");
        mTvDesc.setText(tip);
        mTvWelcome.setText("Welcome,"+getIntent().getStringExtra("name"));
        Resources res = getResources();
        String[] questions = res.getStringArray(R.array.tips);
        List<String> strings = Arrays.asList(questions);
        Random ra =new Random();
        mTvTips.setText(strings.get(   ra.nextInt(5)));

        btn_temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyQueueActivity.class);
                startActivity(intent);
            }
        });
        btn_notepad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyStackActivity.class);
                startActivity(intent);
            }
        });
    }
}