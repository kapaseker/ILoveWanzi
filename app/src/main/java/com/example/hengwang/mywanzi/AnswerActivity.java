package com.example.hengwang.mywanzi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class AnswerActivity extends AssignmentActivity {

    public static final String BUNDLE_KEY_CONTENT = "content";

    EditText mEdtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        mEdtContent = findViewById(R.id.edt_content);
        findViewById(R.id.btn_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEdtContent.getText().toString();

                if (TextUtils.isEmpty(content)) {
                    Snackbar.make(v, "请输入文字", Snackbar.LENGTH_SHORT).show();
                } else {

                    Intent dataIntent = new Intent();
                    dataIntent.putExtra(BUNDLE_KEY_CONTENT, content);
                    setResult(Activity.RESULT_OK, dataIntent);

                    finish();
                }
            }
        });

        mEdtContent.setText(getIntent().getStringExtra(BUNDLE_KEY_CONTENT));
    }
}