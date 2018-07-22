package com.example.hengwang.mywanzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private static final String[] TITLES = new String[]{
            "居中文字", "测试比重", "改变背景", "发起提示", "展示网格列表", "使用ViewPager", "Activity传值", "展示ListView"
    };

    private static final int[] DESCS = new int[]{
            R.string.app_name, R.string.app_name, R.string.assignment_bkg, R.string.assignment_tip, R.string.assignment_grid,
            R.string.assignment_viewpager,
            R.string.assignment_transfer,
            R.string.app_name

    };

    private static final Class[] ACTIVITIES = new Class[]{
            SecondActivity.class, TestLayoutActivity.class, ChangeBackgroundActivity.class, TipActivity.class, GridViewActivity.class,
            ViewPagerAssignmentActivity.class, TransferAssignmentActivity.class, ListViewActivity.class
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
                letsGoAssignment(TITLES[position], DESCS[position], ACTIVITIES[position]);
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
                letsGoAssignment(item.getTitle(), R.string.app_name, WishActivity.class);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void letsGoAssignment(CharSequence title, @StringRes int descId, Class cls) {
        Intent goIntent = new Intent(MainActivity.this, cls);
        goIntent.putExtra(AssignmentActivity.BUNDLE_KEY_TITLE, title);
        goIntent.putExtra(ArrangeAssignmentActivity.BUNDLE_KEY_DESC, descId);
        startActivity(goIntent);
    }
}
