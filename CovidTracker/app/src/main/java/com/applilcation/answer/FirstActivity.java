package com.applilcation.answer;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FirstActivity extends AppCompatActivity {
    private RecyclerView rvFirst;
    private QuestionAdapter adapter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {
        rvFirst = findViewById(R.id.rv_home);
        editText=findViewById(R.id.et_name);
        rvFirst.setLayoutManager(new LinearLayoutManager(this));
        Resources res = getResources();
        String[] questions = res.getStringArray(R.array.questions);
        adapter = new QuestionAdapter();
        rvFirst.setAdapter(adapter);
        adapter.setWormKnowledgeBeans(Arrays.asList(questions));
        findViewById(R.id.btn_check_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(FirstActivity.this, "Pleast input your name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String tips;
                Map<Integer, Boolean> selects = adapter.getSelects();
                if (selects.get(1) || selects.get(4) || selects.get(5)) {
                    tips = " You are not permitted to attend school! And please reach out for medical support immediately.";
                }
                else  if (selects.get(2) || selects.get(3) || selects.get(6)) {
                    tips = " You are not permitted to attend school! Please go home and take care！";

                }
                else {

                    tips = "Welcome to school! Have a good day!";

                }
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                intent.putExtra("tips", tips);
                intent.putExtra("name",editText.getText().toString());
                startActivity(intent);
            }
        });

    }
}