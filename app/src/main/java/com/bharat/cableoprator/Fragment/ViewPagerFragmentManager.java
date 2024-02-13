package com.bharat.cableoprator.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerFragmentManager extends FragmentPagerAdapter {
    public ViewPagerFragmentManager(@NonNull androidx.fragment.app.FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new TVConnection();
        if (position == 1)
            return new BroadbandConnection();
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "TV Connection";
        if (position == 1)
            return "Broadband";
        return null;
    }
}