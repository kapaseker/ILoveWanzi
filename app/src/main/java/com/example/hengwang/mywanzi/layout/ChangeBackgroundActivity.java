package com.example.hengwang.mywanzi.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

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
                mBtnSetText.setEnabled(isEnable);
                mEdtInfo.setEnabled(isEnable);
                if (!isEnable) {
                    mEdtInfo.setText(null);
                }
            }
        });

    }


}

