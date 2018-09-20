package com.example.hengwang.mywanzi.base;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hengwang.mywanzi.R;

public abstract class ArrangeAssignmentActivity extends AssignmentActivity {

    public static final String BUNDLE_KEY_DESC = "Assign.desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrange_assignment);

        TextView txtView = findViewById(R.id.txt_assign);
        txtView.setText(getIntent().getIntExtra(BUNDLE_KEY_DESC, R.string.app_name));

        findViewById(R.id.btn_commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCommitAssigment();
            }
        });
    }

    protected abstract void onCommitAssigment();
}
