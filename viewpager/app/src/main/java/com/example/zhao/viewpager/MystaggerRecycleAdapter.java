package com.example.zhao.viewpager;

import android.graphics.Color;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2017/9/4.
 */

public class MystaggerRecycleAdapter extends RecyclerView.Adapter<MystaggerRecycleAdapter.MystaggerViewHolder> {

    List<String> list=new ArrayList<String>();
    List<Integer> heights=new ArrayList<Integer>();
    private onItemClickLisener monItemClickLisener;

    public MystaggerRecycleAdapter(List<String> list) {
        this.list = list;
        for(int i=0;i<list.size();i++){

            heights.add((int)(Math.random()*50+200));

        }
    }

      public   class MystaggerViewHolder extends RecyclerView.ViewHolder {
           TextView tv;

        public MystaggerViewHolder(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.tv_text);
        }
    }
    @Override
    public MystaggerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//            MystaggerViewHolder holder=new MystaggerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1,viewGroup, false));

        MystaggerViewHolder holder=new MystaggerViewHolder(View.inflate(viewGroup.getContext(),R.layout.paten,null));
        return holder;


    }

    @Override
    public void onBindViewHolder(MystaggerViewHolder holder,  int position) {
       ViewGroup.LayoutParams params= holder.tv.getLayoutParams();
        params.height=heights.get(position);
        holder.tv.setBackgroundColor(Color.rgb((heights.get(position))*255,heights.get(position)*255,heights.get(position)*255));
        holder.tv.setLayoutParams(params);
        holder.tv.setText(""+list.get(position));
        if(monItemClickLisener!=null)
        holder.itemView.setOnClickListener(new MyOnItemClick(position));

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public void  ADDitem(int positon){
        list.add(positon,"additme"+positon);
        //
        notifyItemInserted(positon);
    }

    public void  remove(int positon){
        list.remove(positon);
       notifyItemRemoved(positon);
    }

    public  interface onItemClickLisener{
         void OnItemClick(View view,int position);

    }

    public  void setOnItemClickLisener(onItemClickLisener listener){
        this.monItemClickLisener=listener;
    }
    public class MyOnItemClick implements View.OnClickListener {

        int mPosition;
        View mView;

        public MyOnItemClick(int position) {
            
        }

        @Override
        public void onClick(View v) {
          this.mPosition=mPosition;
        }
    }

}
