package com.example.hamrobaraz.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hamrobaraz.R;

public class ImageSliderAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageIds =new int[]{R.drawable.cars,R.drawable.bikes,R.drawable.tables};

    private int custom_position = 0;
    public ImageSliderAdapter(Context context) {mContext = context; }

    @Override
    public int getCount() { return mImageIds.length; }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

}
