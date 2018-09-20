package com.example.hengwang.mywanzi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hengwang.mywanzi.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        TextView mTextView = (TextView) view.findViewById(R.id.tv_fragment_content);
        mTextView.setText("Fragment1");
        Button mButton = (Button) view.findViewById(R.id.btn_toggle_fragment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment2 f2 = new Fragment2();
                FragmentManager mManager = getFragmentManager();
                FragmentTransaction ft1 = mManager.beginTransaction();
                ft1.addToBackStack(null);//这里将我们的Fragment加入到返回栈
                ft1.replace(R.id.lv_fragment_container, f2);
                ft1.commit();
            }
        });
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }

}