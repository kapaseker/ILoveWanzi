package com.example.hengwang.mywanzi;

import android.content.Intent;

public class FragmentArrangeActivity extends ArrangeAssignmentActivity {
    @Override
    protected void onCommitAssigment() {

        startActivity(new Intent(this, FragmentActivity.class));

    }
}
