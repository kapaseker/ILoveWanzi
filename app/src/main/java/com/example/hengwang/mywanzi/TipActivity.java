package com.example.hengwang.mywanzi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

public class TipActivity extends Activity {
    View mBtnToast;
    View mBtnDialog;
    View mBtnSnackbar;

    public void showExitDialog() {
        new AlertDialog.Builder(this)
                .setTitle("我爱丸子")
                .setMessage("丸子胖胖好可爱。")
                .setPositiveButton("同意", null)
                .setNegativeButton("不同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnSnackbar = findViewById(R.id.btn_snack);


        mBtnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "你好!", Toast.LENGTH_LONG).show();
            }
        });

        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showExitDialog();
            }
        });

        mBtnSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "the snackbar is showing", Snackbar.LENGTH_SHORT).show();
            }
        });


    }
}
