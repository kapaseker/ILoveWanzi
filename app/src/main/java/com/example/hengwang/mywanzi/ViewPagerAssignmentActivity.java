package com.example.hengwang.mywanzi;

import android.content.Intent;

public class ViewPagerAssignmentActivity extends ArrangeAssignmentActivity {

    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }
}
