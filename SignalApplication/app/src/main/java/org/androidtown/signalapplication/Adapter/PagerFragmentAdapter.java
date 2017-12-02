package org.androidtown.signalapplication.Adapter;

import android.support.v4.app.FragmentStatePagerAdapter;

import org.androidtown.signalapplication.Fragments.HomeFragment;
import org.androidtown.signalapplication.Fragments.MoreFragment;
import org.androidtown.signalapplication.Fragments.MypageFragment;
import org.androidtown.signalapplication.Fragments.NoticeFragment;

/**
 * Created by seoyoungoh on 2017. 12. 2..
 */

public class PagerFragmentAdapter extends FragmentStatePagerAdapter {

    public PagerFragmentAdapter(android.support.v4.app.FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new MypageFragment();
            case 2:
                return new NoticeFragment();
            case 3:
                return new MoreFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount()
    {
        return 4;
    }
}
