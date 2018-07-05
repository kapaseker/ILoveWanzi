package com.example.hengwang.mywanzi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

//    String oldText = "";
//    TextView txtName = null;

    private static final String[] strs = new String[]{
            "居中文字", "测试比重", "third", "fourth", "fifth","six"
    };


    //定义一个String数组用来显示ListView的内容
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);//得到ListView对象的引用
        /*为ListView设置Adapter来绑定数据*/
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position 点击的Item位置，从0开始算
                Intent intent = new Intent();
                if (position == 0) {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
                if (position == 1) {
                    startActivity(new Intent(MainActivity.this, TestLayoutActivity.class));
                }
            }});






      /*  txtName = findViewById(R.id.name);
        oldText = txtName.getText().toString();

        findViewById(R.id.btnswitch).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
//                String currentTxt = txtName.getText().toString();
//                if(oldText.equals(currentTxt)){
//                    txtName.setText("hello kitty");
//                }else {
//                    txtName.setText(oldText);
//                }

//                startActivity(new Intent(MainActivity.this,SecondActivity.class));

                startActivity(new Intent(MainActivity.this, TestLayoutActivity.class));
            }
        });*/

        };
    }
