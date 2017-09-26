package com.example.zhao.viewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    private RecyclerView  mRecyclerview;
    private MystaggerRecycleAdapter adapter;
    private List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview=(RecyclerView)findViewById(R.id.recycler);

        for(int i=0;i<50;i++){
            list.add("item"+i);
        }
//        adapter=new MyRecyclerAdapter(list);
        adapter= new MystaggerRecycleAdapter(list);
//         mRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
//        mRecyclerview.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));

        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mRecyclerview.addItemDecoration(dvier);

    }

     private boolean isgrid=false;
    public  void changeview(View v){
        if(!isgrid)
        mRecyclerview.setLayoutManager(new GridLayoutManager(this,3));
        else{
            mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        }
        isgrid=!isgrid;

    }

    public void  addnewItem(View v){
      adapter.ADDitem(1);
    }
    public void  remove(View v){
        if(list.size()>0)
        adapter.ADDitem(list.size()-1);
    }

}
