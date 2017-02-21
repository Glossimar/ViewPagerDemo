package com.bignerdranch.android.viewpagerdemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.sql.Date;
import java.util.logging.Handler;

import static java.util.Date.*;

/**
 * Created by LENOVO on 2017/2/20.
 */

public class ViewPagerNew extends ViewPager {

    private long interval;
    static int currentPosition;
    private MyHandler myHandler;

    public ViewPagerNew(Context context) {
        super(context);
        init();
    }

    public ViewPagerNew(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        myHandler=new MyHandler(this);
        currentPosition=1;
        setCurrentItem(1);
    }

     public void showNextView(){
        setCurrentItem(currentPosition+1,true);
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }


}
