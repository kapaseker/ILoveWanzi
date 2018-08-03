package com.example.hengwang.mywanzi;

import android.content.Intent;

public class LogAndLifeAssignmentActivity extends ArrangeAssignmentActivity {
    @Override
    protected void onCommitAssigment() {

        startActivity(new Intent(LogAndLifeAssignmentActivity.this,ActivityLife1Activity.class));

    }
}
