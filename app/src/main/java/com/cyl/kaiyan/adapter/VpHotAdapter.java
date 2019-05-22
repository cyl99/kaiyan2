package com.cyl.kaiyan.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.nio.channels.Pipe;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/21.
 */

public class VpHotAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mStrings;

    public VpHotAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(fm);
        mFragments = fragments;
        mStrings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStrings.get(position);
    }
}
