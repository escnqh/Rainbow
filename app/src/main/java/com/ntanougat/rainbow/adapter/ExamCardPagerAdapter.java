package com.ntanougat.rainbow.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.entities.CardItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ExamCardPagerAdapter extends PagerAdapter implements CardAdapter {

    private int count=0;
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    private Activity activity;

    public ExamCardPagerAdapter(Activity activity) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        this.activity=activity;
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.view_adapter, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(final CardItem item, View view) {
        ImageView img_pic = view.findViewById(R.id.pic);
        final ImageView img_num=view.findViewById(R.id.number_of_pic);
        Picasso.with(activity)
                .load("http://118.89.50.109:8080"+item.getImgUrl())
                .error(R.drawable.nopic)
                .into(img_pic);
        img_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (!item.getG_id().equals(""+count)){
                    count--;
                    Toast.makeText(activity,"顺序不太对哦~",Toast.LENGTH_SHORT).show();
                }else if (item.getG_id().equals(""+count)){
                    switch (count){
                        case 1:
                            Picasso.with(activity)
                                    .load(R.drawable.ic_1)
                                    .into(img_num);
                            break;
                        case 2:
                            Picasso.with(activity)
                                    .load(R.drawable.ic_2)
                                    .into(img_num);
                            break;
                        case 3:
                            Picasso.with(activity)
                                    .load(R.drawable.ic_3)
                                    .into(img_num);
                            break;
                        case 4:
                            Picasso.with(activity)
                                    .load(R.drawable.ic_4)
                                    .into(img_num);
                            break;
                        case 5:
                            Picasso.with(activity)
                                    .load(R.drawable.ic_5)
                                    .into(img_num);
                            break;
                    }
                }


            }
        });
    }

}
