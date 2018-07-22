package com.example.hengwang.mywanzi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerActivity extends AssignmentActivity {

    ViewPager mPager;

    private static final int[] PICS = new int[]{R.drawable.bkg_bird, R.drawable.bkg_cry, R.drawable.bkg_double, R.drawable.bkg_house};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mPager = findViewById(R.id.viewpager);

        mPager.setAdapter(new PicassoAdapter());
    }

    private class PicassoAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return PICS.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = View.inflate(container.getContext(), R.layout.viewpager_item, null);

            ImageView viewBkg = view.findViewById(R.id.bkg);
            TextView txtInfo = view.findViewById(R.id.txt_info);

            viewBkg.setImageResource(PICS[position]);
            txtInfo.setText("第" + (position + 1) + "页");

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
