package com.applilcation.answer;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyQueueActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    MyQueueAdapter adapter;
    private static MyQueue<String> myQueue = new MyQueue<>(5);
    Button btn_add;
    Button btn_delete;
    EditText input_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_queue);
        initView();
    }

    private void initView() {
        input_msg = findViewById(R.id.input_msg);
        recyclerView = findViewById(R.id.recyclerView);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyQueueAdapter(myQueue);
        recyclerView.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(input_msg.getText().toString())){
                    Toast.makeText(MyQueueActivity.this,"请输入体温",Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    myQueue.add(input_msg.getText().toString());
                    adapter.notifyDataSetChanged();
                }catch (RuntimeException e){
                    Toast.makeText(MyQueueActivity.this,"队列已满",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myQueue.remove();
                    adapter.notifyDataSetChanged();
                }catch (RuntimeException e){
                    Toast.makeText(MyQueueActivity.this,"队列已空",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
