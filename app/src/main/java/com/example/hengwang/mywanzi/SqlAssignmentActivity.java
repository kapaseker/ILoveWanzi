package com.example.hengwang.mywanzi;

import android.content.Intent;

public class SqlAssignmentActivity extends ArrangeAssignmentActivity {
    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(SqlAssignmentActivity.this,SqlActivity.class));

    }
}
