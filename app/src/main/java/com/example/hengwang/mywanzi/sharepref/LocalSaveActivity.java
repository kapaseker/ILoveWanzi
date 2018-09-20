package com.example.hengwang.mywanzi.sharepref;

import android.content.Intent;

import com.example.hengwang.mywanzi.base.ArrangeAssignmentActivity;

public class LocalSaveActivity extends ArrangeAssignmentActivity {

    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(this, SharedPreferencesActivity.class));

    }
}
