package com.example.hengwang.mywanzi.tip;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

import java.util.Calendar;

public class TipActivity extends AssignmentActivity {
    View mBtnToast;
    View mBtnDialog;
    View mBtnSnackbar;
    View mBtndate;
    View mBtnTime;
    View mBtnLoad;

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


    private void showWaitingDialog() {
        /* 等待Dialog具有屏蔽其他控件的交互能力
         * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
         * 下载等事件完成后，主动调用函数关闭该Dialog
         */
        ProgressDialog waitingDialog =
                new ProgressDialog(TipActivity.this);
        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(true);
        waitingDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消"
                , new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface d, int i) {
                        d.cancel();
                    }
                });
        waitingDialog.show();
    }


    private void showCustomizeDialog() {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(TipActivity.this);
        final View dialogView = LayoutInflater.from(TipActivity.this)
                .inflate(R.layout.dialog_customize, null);
        customizeDialog.setTitle("我是一个自定义Dialog");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容
                        EditText edit_text =
                                (EditText) dialogView.findViewById(R.id.edit_text);
                        Toast.makeText(TipActivity.this,
                                edit_text.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        customizeDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnSnackbar = findViewById(R.id.btn_snack);
        mBtndate = findViewById(R.id.btn_date);
        mBtnTime = findViewById(R.id.btn_time);
        mBtnLoad = findViewById(R.id.btn_loading);


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

        mBtndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                final int mYear = c.get(Calendar.YEAR);
                final int mMonth = c.get(Calendar.MONTH);
                final int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TipActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String nyear = String.valueOf(year);
                        String nmonth = String.valueOf(month + 1);
                        String ndayOfMonth = String.valueOf(dayOfMonth);

                        Snackbar.make(mBtndate, nyear + nmonth + ndayOfMonth, Snackbar.LENGTH_SHORT).show();


                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();


            }
        });

        mBtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timeDialog = new TimePickerDialog(TipActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String nhourOfDay = String.valueOf(hourOfDay);
                        String nminute = String.valueOf(minute);


                        Snackbar.make(mBtnTime, nhourOfDay + nminute, Snackbar.LENGTH_SHORT).show();
                    }
                }, 0, 0, true);
                timeDialog.show();

            }

        });

        mBtnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWaitingDialog();


            }
        });


    }
}
