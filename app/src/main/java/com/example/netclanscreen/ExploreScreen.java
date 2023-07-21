package com.example.netclanscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class ExploreScreen extends AppCompatActivity {
    ImageView refine, menu;
    TabLayout tab;
    ViewPager2 viewPager;
    ViewPagerAdapter ViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_screen);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(ViewPagerAdapter);
        refine = findViewById(R.id.refine);
        menu = findViewById(R.id.imageView);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tab.getTabAt(position).select();
            }
        });
        refine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileScreen.class);
                startActivity(intent);
            }
        });
    }
}