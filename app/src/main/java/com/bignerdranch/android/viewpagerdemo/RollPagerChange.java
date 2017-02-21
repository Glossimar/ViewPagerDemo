package com.bignerdranch.android.viewpagerdemo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by LENOVO on 2017/2/20.
 */

public class RollPagerChange implements ViewPager.OnPageChangeListener {
    private View v;
    private long lastDate;
    private MyHandler myHandler=new MyHandler(MainActivity.viewPager);
    private TextView textView;
    private List<String> textList;
    private ImageView imageView;
    private LinearLayout layout;
    private int pagerAdapterNum;

    public RollPagerChange(LinearLayout linearLayout, List<String> texts,int pagerAdapterNum){
        this.textList=texts;
        this.layout=linearLayout;
        this.pagerAdapterNum=pagerAdapterNum;
//        this.v=v;
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        ViewPagerNew.currentPosition=position;
       if (position==0) {
           int last = ViewPagerNew.currentPosition;
           ViewPagerNew.currentPosition = pagerAdapterNum - 2;
       }else if (position==(pagerAdapterNum-1)) {
           int last=ViewPagerNew.currentPosition;
           ViewPagerNew.currentPosition=1;
        }
        imageView=null;
        for (int i=0;i<layout.getChildCount();i++){
            imageView=(ImageView)layout.getChildAt(position);
            if (i==position){
                imageView.setImageResource(R.drawable.page_now);
            }else {
//                imageView.setImageResource(R.drawable.page);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case ViewPager.SCROLL_STATE_DRAGGING:
                Log.d(TAG, "onPageScrollStateChanged:       正在滚动 ");
                pauseScroll();
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                Log.d(TAG, "onPageScrollStateChanged:        开始滚动");
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                Log.d(TAG, "onPageScrollStateChanged:         正在设置页面");
                MainActivity.viewPager.setCurrentItem(ViewPagerNew.currentPosition,false);
                logDate();
                resumeScroll();
                break;
        }
    }

    public void resumeScroll(){
        myHandler.sendMessageDelayed(myHandler.obtainMessage(MyHandler.MESSAGE_CHECK),5000);
    }

    public void pauseScroll(){
//        if ()
        myHandler.removeMessages(MyHandler.MESSAGE_CHECK);
    }

    private void logDate(){
        long now = new Date(lastDate).getTime();
        if (lastDate==0){
            lastDate=now;
            return;
        }
//        long interval=now-lastDate;
        lastDate=now;
    }
}
