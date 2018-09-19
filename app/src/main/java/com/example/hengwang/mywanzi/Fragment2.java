package com.example.hengwang.mywanzi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

class Fragment2 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        TextView mTextView = (TextView) view.findViewById(R.id.tv_fragment_content);
        mTextView.setText("Fragment2");
        Button mButton = (Button) view.findViewById(R.id.btn_toggle_fragment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment1 f1 = new Fragment1();
                FragmentManager mManager = getFragmentManager();
                FragmentTransaction ft2 = mManager.beginTransaction();
                ft2.addToBackStack(null);//这里将我们的Fragment加入到返回栈
                ft2.replace(R.id.lv_fragment_container, f1);
                ft2.commit();
            }
        });
        return view;
    }
}
