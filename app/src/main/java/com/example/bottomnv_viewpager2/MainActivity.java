package com.example.bottomnv_viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bottomnv_viewpager2.Tranformer.DepthPageTransformer;
import com.example.bottomnv_viewpager2.Tranformer.ZoomOutPageTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigationView;
    private MyAdapter_ViewPager adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager2 = (ViewPager2) findViewById(R.id.viewPager2);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBottom);

        adapter = new MyAdapter_ViewPager(this);
        mViewPager2.setAdapter(adapter);

        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.item_home:
                        mViewPager2.setCurrentItem(0);
                        break;
                    case R.id.item_favorite:
                        mViewPager2.setCurrentItem(1);
                        break;
                    case R.id.item_history:
                        mViewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.item_home).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.item_favorite).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.item_history).setChecked(true);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.itemZoom:
                    mViewPager2.setPageTransformer(new ZoomOutPageTransformer());
                break;
            case R.id.itemDepth:
                    mViewPager2.setPageTransformer(new DepthPageTransformer());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}