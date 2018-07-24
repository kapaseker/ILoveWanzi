package com.example.hengwang.mywanzi;

import android.content.Intent;

public class OpenContractAssignmentActivity extends ArrangeAssignmentActivity {

    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(this, contactActivity.class));

    }
}
