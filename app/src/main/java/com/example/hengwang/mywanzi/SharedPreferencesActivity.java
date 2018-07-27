package com.example.hengwang.mywanzi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SharedPreferencesActivity extends AssignmentActivity {
    TextView mEditView;
    Button mBtnWriteSP;
    Button mBtnReadSP;
    Button mBtnWriteLocal;
    Button mBtnReadLocal;
    Button mBtnWriteSD;
    Button mBtnReadSD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEditView = findViewById(R.id.mInfo);
        mBtnWriteSP = findViewById(R.id.btn_writeSP);
        mBtnReadSP = findViewById(R.id.btn_readSP);
        mBtnWriteLocal = findViewById(R.id.btn_writeinter);
        mBtnReadLocal = findViewById(R.id.btn_readinter);
        mBtnWriteSD = findViewById(R.id.btn_writeOuter);
        mBtnReadSD = findViewById(R.id.btn_readOuter);
        String str = mEditView.getText().toString();

        //绑定监听事件
        mBtnWriteSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获得SharedPreferences的实例 zhu_sp是文件名
                SharedPreferences sp = getSharedPreferences("zhu_sp", Context.MODE_PRIVATE);
//获得Editor 实例
                SharedPreferences.Editor editor = sp.edit();
                String str = mEditView.getText().toString();

                if (!str.isEmpty()) {
                    //以key-value形式保存数据
                    editor.putString("data_key", str);
//apply()是异步写入数据
                    editor.apply();
//commit()是同步写入数据
//editor.commit();
                    Toast.makeText(SharedPreferencesActivity.this, "输入成功", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SharedPreferencesActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mBtnReadSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获得SharedPreferences的实例
                SharedPreferences sp = getSharedPreferences("zhu_sp", Context.MODE_PRIVATE);
                //通过key值获取到相应的data，如果没取到，则返回后面的默认值
                String data = sp.getString("data_key", "defaultValue");
                mEditView.setText(data);
            }
        });

        mBtnWriteLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FILENAME = "zhu.txt";

                String str = mEditView.getText().toString();

                FileOutputStream fos = null;
                if (!str.isEmpty()) {
                    try {
                        fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                        fos.write(str.getBytes());
                        fos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(SharedPreferencesActivity.this, "输入成功", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SharedPreferencesActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                }


            }
        });


        mBtnReadLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FILENAME = "zhu.txt";
                FileInputStream ios = null;
                try {
                    ios = openFileInput(FILENAME);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(ios));
                StringBuilder sb = new StringBuilder();
                String content;

                try {
                    content = br.readLine();
                    while (content != null) {
                        sb.append(content);
                        content = br.readLine();

                    }
                    mEditView.setText(br.toString());


                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        if (br != null) {
                            br.close();
                        }
                        if (ios != null) {
                            ios.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }
        });

        mBtnWriteSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        mBtnReadSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }
}
