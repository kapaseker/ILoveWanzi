package com.example.hengwang.mywanzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private static final String[] TITLES = new String[]{
            "居中文字", "测试比重", "改变背景", "发起提示"
    };

    private static final Class[] ACTIVITIES = new Class[]{
            SecondActivity.class, TestLayoutActivity.class, ChangeBackgroundActivity.class, TipActivity.class
    };


    /**
     * 定义一个String数组用来显示ListView的内容
     */
    private ListView mListAssignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListAssignments = findViewById(R.id.lv);//得到ListView对象的引用
        /*为ListView设置Adapter来绑定数据*/
        mListAssignments.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, TITLES));

        mListAssignments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                letsGoAssignment(TITLES[position], ACTIVITIES[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_my_wish:
                letsGoAssignment(item.getTitle(), WishActivity.class);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void letsGoAssignment(CharSequence title, Class cls) {
        Intent goIntent = new Intent(MainActivity.this, cls);
        goIntent.putExtra(AssignmentActivity.BUNDLE_KEY_TITLE, title);
        startActivity(goIntent);
    }
}
