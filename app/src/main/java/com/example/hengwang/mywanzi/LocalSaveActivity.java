package com.example.hengwang.mywanzi;

import android.content.Intent;

public class LocalSaveActivity extends ArrangeAssignmentActivity {

    @Override
    protected void onCommitAssigment() {
        startActivity(new Intent(this, SharedPreferencesActivity.class));

    }
}
