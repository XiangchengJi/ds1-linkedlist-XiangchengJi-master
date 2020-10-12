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

public class MyStackActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    MyStackAdapter adapter;
    private static MyStack<String> myStack = new MyStack<>();
    Button btn_add;
    Button btn_delete;
    EditText input_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stack);
        initView();
    }

    private void initView() {
        input_msg = findViewById(R.id.input_msg);
        recyclerView = findViewById(R.id.recyclerView);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyStackAdapter(myStack);
        recyclerView.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(input_msg.getText().toString())){
                    Toast.makeText(MyStackActivity.this,"请输入记事信息",Toast.LENGTH_SHORT).show();
                    return;
                }
                myStack.push(input_msg.getText().toString());
                adapter.notifyDataSetChanged();

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStack.pop();
                adapter.notifyDataSetChanged();
            }
        });
    }
}