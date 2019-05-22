package com.cyl.kaiyan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/15.
 */

public class VpHomeAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;
    private ArrayList<Integer> mStrings;
    private Context mContext;

    public VpHomeAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<Integer> strings, Context context) {
        super(fm);
        mFragments = fragments;
        mStrings = strings;
        mContext = context;
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

        return mContext.getResources().getString(mStrings.get(position));
    }
}
