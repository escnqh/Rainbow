package com.ntanougat.rainbow.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.entities.DownLoadStoryBean;
import com.ntanougat.rainbow.entities.MyStorysBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Peelson on 2017/12/12.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    private List<DownLoadStoryBean> myStorys;
    private Activity mActivity;

    public SearchResultAdapter(List<DownLoadStoryBean> myStorys, Activity activity){
        this.mActivity=activity;
        this.myStorys=myStorys;
    }


    @Override
    public SearchResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SearchResultAdapter.ViewHolder holder, int position) {
        if(myStorys.get(position).getStory().size()!=0){
            SetImageBitmap(holder,"http://118.89.50.109:8080"+myStorys.get(position).getStory().get(0).getPicture_url());
        }
        Log.i("LoadRecyclerViewPosi","     "+position);
        String title=myStorys.get(position).getP_title();
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

    private void SetImageBitmap(SearchResultAdapter.ViewHolder holder, String path){

        if (path != null) {
            Picasso.with(mActivity)
                    .load(path)
                    .placeholder(R.drawable.nopic)
                    .error(R.drawable.nopic)
                    .into(holder.iv_firstpage);
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
