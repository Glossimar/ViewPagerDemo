package com.bignerdranch.android.viewpagerdemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by LENOVO on 2017/2/20.
 */

public class RollViewPagerAdapter extends PagerAdapter {
    private List<ImageView> images;


    public RollViewPagerAdapter(List<ImageView> images){
        this.images=images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=images.get(position);
        container.addView(view);
        return view;
    }



}
