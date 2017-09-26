package com.example.zhao.tablelayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/9/25.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private  List<String> list =new ArrayList<>();
    private Context mContext;

    public MyViewPagerAdapter(FragmentManager fm, List<String> list, Context mContext) {
        super(fm);
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position);
    }

    @Override
    public Fragment getItem(int position) {
       Fragment f=new newsFragmen();
        Bundle bundle=new Bundle();
        bundle.putString("title",list.get(position));
        f.setArguments(bundle);
        return f;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
