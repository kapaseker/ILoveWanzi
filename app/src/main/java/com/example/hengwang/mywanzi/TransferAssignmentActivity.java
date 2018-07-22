package com.example.hengwang.mywanzi;

import android.content.Intent;

public class TransferAssignmentActivity extends ArrangeAssignmentActivity {

    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(this, QuestionActivity.class));
    }
}
