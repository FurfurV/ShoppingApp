package com.example.viktoria_cseke_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private BreadFragment breadFragment;
    private DairyFragment dairyFragment;
    private ProduceFragment produceFragment;
    private MeatFragment meatFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        breadFragment = new BreadFragment();
        dairyFragment = new DairyFragment();
        produceFragment = new ProduceFragment();
        meatFragment = new MeatFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(breadFragment,"Bread");
        viewPagerAdapter.addFragment(dairyFragment,"Dairy");
        viewPagerAdapter.addFragment(produceFragment,"Produce");
        viewPagerAdapter.addFragment(meatFragment,"Meat");
        viewPager.setAdapter(viewPagerAdapter);
    }
}