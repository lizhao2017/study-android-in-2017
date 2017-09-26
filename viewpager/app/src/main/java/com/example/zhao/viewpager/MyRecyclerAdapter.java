package com.example.zhao.viewpager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/9/4.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHoder> {
   private List<String> list=new ArrayList<String>();

    public MyRecyclerAdapter(List<String> list) {
        this.list=list;
    }


    class MyViewHoder extends RecyclerView.ViewHolder{
           TextView tv;
        public MyViewHoder(View view) {
            super(view);
            tv=(TextView)view.findViewById(android.R.id.text1);

        }
    }



    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        MyViewHoder holder=new MyViewHoder(View.inflate(viewGroup.getContext(),android.R.layout.simple_list_item_1,null));
        return holder;
    }
//绑定viewholder
    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {
       holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void  ADDitem(int positon){
        list.add(positon,"additme"+positon);
    }
}
