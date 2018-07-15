package com.example.hengwang.mywanzi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
