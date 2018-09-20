package com.example.hengwang.mywanzi.activitylife;

import android.os.Bundle;
import android.util.Log;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

public class ActivityLife2Activity extends AssignmentActivity {
    String Tag1 = "LOGIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life2);

        Log.i(Tag1, "the second activity onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag1, "the second activity onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
          Log.i(Tag1, "the second activity onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
          Log.i(Tag1, "the second activity onSesume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag1, "the second activity onPause");
    }
      @Override
    protected void onDestroy() {
        super.onDestroy();
         Log.i(Tag1, "the second activity onDestroy");
    }

}
