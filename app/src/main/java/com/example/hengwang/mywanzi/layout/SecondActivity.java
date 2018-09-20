package com.example.hengwang.mywanzi.layout;

import android.os.Bundle;
import android.view.View;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

public class SecondActivity extends AssignmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        findViewById(R.id.btnback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
