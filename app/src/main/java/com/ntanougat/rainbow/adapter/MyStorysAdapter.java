package com.ntanougat.rainbow.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.entities.Story;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Peelson on 2017/12/12.
 */

public class MyStorysAdapter extends RecyclerView.Adapter<MyStorysAdapter.ViewHolder> {

    private List<Story> myStorys;
    private Activity mActivity;

    public MyStorysAdapter(List<Story> myStorys,Activity activity){
        this.mActivity=activity;
        this.myStorys=myStorys;
    }

    @Override
    public MyStorysAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyStorysAdapter.ViewHolder holder, int position) {

        SetImageBitmap(holder,myStorys.get(position).getSituationBeans().get(0).getImgUrl());
        String title=myStorys.get(position).getTitle();
        holder.tv_title.setText(title);
        if (OnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition();
                    OnItemClickListener.onItemClick(holder.itemView,position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = holder.getLayoutPosition();
                    OnItemClickListener.onItemLongClick(holder.itemView,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return myStorys.size();
    }

    private void SetImageBitmap(MyStorysAdapter.ViewHolder holder,String path){

        if (path != null) {
            Picasso.with(mActivity).load(path).into(holder.iv_firstpage);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_firstpage;
        private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_firstpage=itemView.findViewById(R.id.iv_fistpage);
            tv_title=itemView.findViewById(R.id.tv_title);
        }
    }

    //点击事件
    public interface OnItemClickListener{
        void  onItemClick(View view, int position);
        void  onItemLongClick(View view, int position);
    }
    private OnItemClickListener OnItemClickListener;

    public void SetOnItemClickListener(OnItemClickListener onItemClickListener){
        OnItemClickListener =onItemClickListener;
    }
}
