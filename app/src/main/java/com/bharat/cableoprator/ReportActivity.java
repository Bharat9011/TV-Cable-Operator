package com.bharat.cableoprator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bharat.cableoprator.Fragment.ViewPagerFragmentManager;
import com.google.android.material.tabs.TabLayout;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_fragment);

        getSupportActionBar().setTitle("Report");

        TabLayout tablayout = findViewById(R.id.tablayout);
        ViewPager viewPager = findViewById(R.id.viewpager);

        ViewPagerFragmentManager fragmentManager = new ViewPagerFragmentManager(getSupportFragmentManager());
        viewPager.setAdapter(fragmentManager);

        tablayout.setupWithViewPager(viewPager);

    }
}
