package com.example.hengwang.mywanzi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class ChangeBackgroundActivity extends AppCompatActivity {

    EditText mEdtInfo;
    View mBtnSetText;
    ToggleButton mTglEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);

        mEdtInfo = findViewById(R.id.input);
        mBtnSetText = findViewById(R.id.set_text);
        mTglEnable = findViewById(R.id.tgl_enable);
    }
}
