package com.example.hengwang.mywanzi.fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

public class FragmentActivity extends AssignmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Fragment1 f1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.lv_fragment_container, f1, "first").commit();
    }

    public void onBackPressed() {
        Toast.makeText(FragmentActivity.this, "left count:" + getSupportFragmentManager().getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
        //取出我们返回栈存在Fragment的个数
        if (getSupportFragmentManager().getBackStackEntryCount() <= 0) {
            finish();
        } else {
            getSupportFragmentManager().popBackStack();
        }
        //取出返回栈保存的Fragment,这里会从栈顶开始出栈
    }

}
