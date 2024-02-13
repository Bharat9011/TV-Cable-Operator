package com.bharat.cableoprator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerlayout;
    private BottomNavigationView Bottom_Navigation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNavigationViewListener();

        Bottom_Navigation_view = findViewById(R.id.Bottom_Navigation_view);

        Bottom_Navigation_view.setOnNavigationItemSelectedListener(bottomNavigationView);

        drawerlayout = findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close);

        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart() {
        loading(new DashBoardFragment());
        getSupportActionBar().setTitle("DashBoard");
        super.onStart();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationView = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == R.id.dashboard) {
                loading(new DashBoardFragment());
                getSupportActionBar().setTitle("DashBoard");
            } else if (item.getItemId() == R.id.customer) {
                loading(new CustomerDashBoard());
                getSupportActionBar().setTitle("Customer DashBoard");
            } else if (item.getItemId() == R.id.report) {
                startActivity(new Intent(MainActivity.this, ReportActivity.class));
            } else if (item.getItemId() == R.id.profile){
                loading(new ProfileFragment());
                getSupportActionBar().setTitle("Profile");
            }

            return true;
        }
    };

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loading(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.loading_frag, fragment);
        fragmentTransaction.commit();
    }
}