package com.example.hengwang.mywanzi;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class ChangeBackgroundActivity extends AssignmentActivity {

    EditText mEdtInfo;
    View mBtnSetText;
    ToggleButton mTglEnable;
//   public boolean isEnable = true;
    String mText = "i love wanzi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);

        mEdtInfo = findViewById(R.id.input);
        mBtnSetText = findViewById(R.id.set_text);
        mTglEnable = findViewById(R.id.tgl_enable);

        mBtnSetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mEdtInfo.setText(mText);
                mEdtInfo.setSelection(mText.length());//set cursor to the end

            }
        });
        mTglEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isEnable) {
                if (!isEnable) {

                    mBtnSetText.setEnabled(false);
                    mEdtInfo.setText(null);
                    mEdtInfo.setEnabled(false);
                } else {

                    mBtnSetText.setEnabled(true);
                    mEdtInfo.setEnabled(true);
                }
            }
        });

    }


        }

