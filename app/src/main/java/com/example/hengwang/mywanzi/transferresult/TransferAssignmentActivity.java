package com.example.hengwang.mywanzi.transferresult;

import android.content.Intent;

import com.example.hengwang.mywanzi.base.ArrangeAssignmentActivity;

public class TransferAssignmentActivity extends ArrangeAssignmentActivity {

    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(this, QuestionActivity.class));
    }
}
