package com.example.na_data_2023_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class ImagesActivity extends Fragment {
    Activity activity;
    private ViewPager2 sliderViewPager;
    private LinearLayout layoutIndicator;

    private String[] images = new String[] {
            "https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg",
            "https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg",
            "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg"
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity)
            activity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_shorts, container, false);

        sliderViewPager = v.findViewById(R.id.sliderViewPager);
//        layoutIndicator = v.findViewById(R.id.layoutIndicators);

        sliderViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(activity, images));

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                setCurrentIndicator(position);
            }
        });

//        setupIndicators(images.length);

        return v;
    }

//    private void setupIndicators(int count) {
//        ImageView[] indicators = new ImageView[count];
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        params.setMargins(16, 8, 16, 8);
//
//        for (int i = 0; i < indicators.length; i++) {
//            indicators[i] = new ImageView(activity);
//            indicators[i].setImageDrawable(ContextCompat.getDrawable(activity,
//                    R.drawable.bg_indicator_inactive));
//            indicators[i].setLayoutParams(params);
//            layoutIndicator.addView(indicators[i]);
//        }
//        setCurrentIndicator(0);
//    }

//    private void setCurrentIndicator(int position) {
//        int childCount = layoutIndicator.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
//            if (i == position) {
//                imageView.setImageDrawable(ContextCompat.getDrawable(
//                        activity,
//                        R.drawable.bg_indicator_active
//                ));
//            } else {
//                imageView.setImageDrawable(ContextCompat.getDrawable(
//                        activity,
//                        R.drawable.bg_indicator_inactive
//                ));
//            }
//        }
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}