package com.bignerdranch.android.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

//import com.bignerdranch.android.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ImageView> imageViewList;
    private List<String> textList;
    private LinearLayout layout;
    private LinearLayout.LayoutParams layoutParams;
    public static ViewPagerNew viewPager;
    private RollPagerChange rollPagerChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPagerNew)findViewById(R.id.rollViewPager);
        layout=(LinearLayout)findViewById(R.id.dot);
        rollPagerChange=new RollPagerChange(layout,textList,5);
        viewPager.setInterval(50000);
        rollPagerChange.resumeScroll();
        initViews();
        viewPager.setOnPageChangeListener(rollPagerChange);
    }

    private void initViews(){
        imageViewList=new ArrayList<ImageView>();
//
        ImageView dotView=null;
        layoutParams=new LinearLayout.LayoutParams(ViewPager.LayoutParams.WRAP_CONTENT,ViewPager.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin=5;
        ImageView imageView=null;
        imageView=new ImageView(getApplicationContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.slide3);
        imageViewList.add(0,imageView);

        for (int i=1;i<=3;i++){
            imageView=new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            int intresId=getResources().getIdentifier("slide"+i,"drawable",getPackageName());
            imageView.setImageResource(intresId);

            imageViewList.add(i,imageView);

            switch (i){
                case 1:imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"dddddddddddddddddddd",Toast.LENGTH_SHORT).show();
                    }
                });
                    break;
                case 2:
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(MainActivity.this,Page1.class);
                            startActivity(intent);
                        }
                    });
                    break;
                case 3:
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this,"eeeeeeeeeeeeeeeeeeeeee",Toast.LENGTH_LONG).show();
                            Intent intent1=new Intent(MainActivity.this,Page1.class);
                            startActivity(intent1);
                        }
                    });
                    break;
            }
            imageViewList.add(imageView);

            dotView=new ImageView(getApplicationContext());
            if(i==1){
                dotView.setImageResource(R.drawable.page_now);
            }else {
                dotView.setImageResource(R.drawable.page);
            }
            dotView.setTag(i);
            dotView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id=(Integer)v.getTag();
                     viewPager.setCurrentItem(id);
                }
            });
            layout.addView(dotView,layoutParams);
        }

        imageView=new ImageView(getApplicationContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.slide1);
        imageViewList.add(4,imageView);

        viewPager.setAdapter(new RollViewPagerAdapter(imageViewList));
        viewPager.setOffscreenPageLimit(imageViewList.size());
    }
}
