package com.example.hengwang.mywanzi.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hengwang.mywanzi.R;
import com.example.hengwang.mywanzi.base.AssignmentActivity;

public class ActivityLife1Activity extends AssignmentActivity {
    String Tag1 = "LOGIn";
    Button btnNewLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life1);
        btnNewLife=findViewById(R.id.btn_newLife);
        btnNewLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityLife1Activity.this,ActivityLife2Activity.class));
            }
        });

        Log.i(Tag1, "the first activity onCreate");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag1, "the first activity onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
          Log.i(Tag1, "the first activity onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
          Log.i(Tag1, "the first activity onSesume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag1, "the first activity onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
         Log.i(Tag1, "the first activity onDestroy");
    }
}
