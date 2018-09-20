package com.example.hengwang.mywanzi.wish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

public class WishActivity extends AssignmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);

        findViewById(R.id.btn_clickme).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clickme:
                startActivity(new Intent(this, WhatDrawActivity.class));
                break;
        }
    }
}
