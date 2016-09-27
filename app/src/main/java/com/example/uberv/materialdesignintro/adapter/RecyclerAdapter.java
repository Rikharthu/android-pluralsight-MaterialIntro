package com.example.uberv.materialdesignintro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uberv.materialdesignintro.R;
import com.example.uberv.materialdesignintro.model.Landscape;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    public static final String TAG=RecyclerAdapter.class.getSimpleName();

    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Landscape> data) {
        mData=data;
        // obtain inflater from passed context
        mInflater= LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder()");

        // inflate view
        View view = mInflater.inflate(R.layout.list_item,parent,false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder() "+position);

        // bind data to view using ViewHolder
        Landscape currentObj = mData.get(position);
        holder.setData(currentObj,position);
    }

    @Override
    public int getItemCount() {
        // return length of our list
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemView) {
            // get references to views
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
        }

        /** Databind views */
        public void setData(Landscape current, int position) {
            title.setText(current.getTitle());
            imgThumb.setImageResource(current.getImageID());
            this.position=position;
            this.current=current;
        }
    }

}
