package com.example.hengwang.mywanzi.sql;

import android.content.Intent;

import com.example.hengwang.mywanzi.base.ArrangeAssignmentActivity;

public class SqlAssignmentActivity extends ArrangeAssignmentActivity {
    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(SqlAssignmentActivity.this,SqlActivity.class));

    }
}
