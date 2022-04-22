package com.example.bottomnv_viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter_ViewPager extends FragmentStateAdapter {


    public MyAdapter_ViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Home_Fragment();
            case 1:
                return new Favorite_Fragment();
            case 2:
                return new History_Fragment();
            default:
                return new Home_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
