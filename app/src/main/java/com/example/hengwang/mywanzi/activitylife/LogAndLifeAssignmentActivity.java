package com.example.hengwang.mywanzi.activitylife;

import android.content.Intent;

import com.example.hengwang.mywanzi.base.ArrangeAssignmentActivity;

public class LogAndLifeAssignmentActivity extends ArrangeAssignmentActivity {
    @Override
    protected void onCommitAssigment() {

        startActivity(new Intent(LogAndLifeAssignmentActivity.this,ActivityLife1Activity.class));

    }
}
