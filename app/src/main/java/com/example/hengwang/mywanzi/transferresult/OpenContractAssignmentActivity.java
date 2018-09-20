package com.example.hengwang.mywanzi.transferresult;

import android.content.Intent;

import com.example.hengwang.mywanzi.base.ArrangeAssignmentActivity;

public class OpenContractAssignmentActivity extends ArrangeAssignmentActivity {

    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(this, ContactActivity.class));

    }
}
