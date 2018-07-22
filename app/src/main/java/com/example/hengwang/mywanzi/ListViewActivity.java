package com.example.hengwang.mywanzi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends AssignmentActivity {

    ListView mLstInfo;

    private static final String[] INFOS = new String[]{"apple", "google", "facebook", "grape"};

    private static final int[] PICS = new int[]{R.drawable.bkg_bird, R.drawable.bkg_cry, R.drawable.bkg_double, R.drawable.bkg_house};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mLstInfo = findViewById(R.id.lstview);


        mLstInfo.setAdapter(new InfoAdapter());
    }

    private static class InfoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return INFOS.length;
        }

        @Override
        public String getItem(int position) {
            return INFOS[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null);

            ImageView imageView = view.findViewById(R.id.img_icon);
            TextView txtView = view.findViewById(R.id.txt_title);

            txtView.setText(INFOS[position]);
            imageView.setImageResource(PICS[position]);

            return view;
        }
    }
}
