package com.example.hengwang.mywanzi.wish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

public class WhatDrawActivity extends AssignmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_draw);

        findViewById(R.id.btn_guess).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_guess:
                startActivity(new Intent(this, ILoveActivity.class));
                finish();
                break;
        }
    }
}
