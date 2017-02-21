package com.bignerdranch.android.viewpagerdemo;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by LENOVO on 2017/2/20.
 */

public class MyHandler extends Handler {
    public static final int MESSAGE_CHECK=9001;
    private WeakReference<ViewPagerNew> innerObject;

    public MyHandler(ViewPagerNew viewPagerNew){
        this.innerObject=new WeakReference<ViewPagerNew>(viewPagerNew);
    }

    @Override
    public void handleMessage(Message msg) {
        if (MESSAGE_CHECK==msg.what){
            ViewPagerNew viewPagerNew=innerObject.get();
            if (viewPagerNew.getContext() instanceof Activity){
                Activity activity=(Activity)viewPagerNew.getContext();
                if (activity.isFinishing()){
                    return;
                }
            }
            viewPagerNew.showNextView();

            removeMessages(MESSAGE_CHECK);
            sendMessageDelayed(obtainMessage(MESSAGE_CHECK),viewPagerNew.getInterval());
        }
        super.handleMessage(msg);
    }
}
