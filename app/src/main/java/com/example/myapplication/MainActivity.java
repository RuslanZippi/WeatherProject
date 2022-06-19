package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.fragment.MainFragment;
import com.example.myapplication.fragment.StatsFragment;
import com.example.myapplication.fragment.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    MainFragment mainFragment;
    VideoFragment videoFragment;
    StatsFragment statsFragment;
    FragmentTransaction fragmentTransaction;

    BottomNavigationView bottomNavigationView;

    public static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mainFragment = new MainFragment();

        mainActivity = this;

        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.getMenu().getItem(1).setVisible(true);

        fragmentTransaction.replace(R.id.fragment,mainFragment);
        fragmentTransaction.commit();


        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mainFragment = new MainFragment();
                videoFragment = new VideoFragment();
                statsFragment = new StatsFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                int id = item.getItemId();
                switch (id){
                    case R.id.stats_bar:
                        fragmentTransaction.replace(R.id.fragment,statsFragment);
                        fragmentTransaction.commit();
                        break;
                    case R.id.profile_bar:
                        fragmentTransaction.replace(R.id.fragment,videoFragment);
                        fragmentTransaction.commit();
                        break;
                    case R.id.home_bar:
                        fragmentTransaction.replace(R.id.fragment,mainFragment);
                        fragmentTransaction.commit();
                        break;

                }
                return true;
            }
        });


    }
}