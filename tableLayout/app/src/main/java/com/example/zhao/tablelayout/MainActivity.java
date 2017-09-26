package com.example.zhao.tablelayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    List<String> list=new ArrayList<>();
    private TabLayout mTableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mTableLayout= (TabLayout) findViewById(R.id.tb);
        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(),list,MainActivity.this);

       mTableLayout.setTabsFromPagerAdapter(adapter);
        //tablayout滑动关联viewpager
        mTableLayout.setOnTabSelectedListener(this);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTableLayout));

        mViewPager.setAdapter(adapter);

//        mTableLayout.setupWithViewPager(mViewPager);
    }

    private void init() {
                list.add("8月");
               list.add("7月");
               list.add("5月");
               list.add("4月");
               list.add("3月");
               list.add("8月");
               list.add("9月");
               list.add("10月");

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
       //被选中的时候回
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
