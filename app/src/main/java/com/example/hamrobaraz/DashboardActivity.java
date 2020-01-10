package com.example.hamrobaraz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity {
    Toolbar mainToolbar;
    ImageView imgLoginIcon;
    RecyclerView rvCategory,rvTrendingProducts, revRecentlyListedAds;

    ViewPager viewPager;
    LinearLayout sliderDotsPanel;
    private int dotscount;
    private  ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        imgLoginIcon = findViewById(R.id.imgLoginIcon);
        imgLoginIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
