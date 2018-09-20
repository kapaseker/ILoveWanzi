package com.example.hengwang.mywanzi.fragment;

import android.content.Intent;

import com.example.hengwang.mywanzi.base.ArrangeAssignmentActivity;

public class FragmentArrangeActivity extends ArrangeAssignmentActivity {
    @Override
    protected void onCommitAssigment() {

        startActivity(new Intent(this, FragmentActivity.class));

    }
}
