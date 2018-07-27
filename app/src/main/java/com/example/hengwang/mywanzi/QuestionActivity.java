package com.example.hengwang.mywanzi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class QuestionActivity extends AssignmentActivity {

    TextView mTxtInfo;
    Button mBtnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mTxtInfo = findViewById(R.id.txt_info);
        mBtnGo = findViewById(R.id.btn_go);

        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
                intent.putExtra(AnswerActivity.BUNDLE_KEY_CONTENT, UUID.randomUUID().toString());
                startActivityForResult(intent, 3);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 3:

                if (Activity.RESULT_OK == resultCode) {
                    String content = data.getStringExtra(AnswerActivity.BUNDLE_KEY_CONTENT);
                    mTxtInfo.setText(content);
                } else {
                    Toast.makeText(this, "用户取消了", Toast.LENGTH_SHORT).show();
                }

                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}