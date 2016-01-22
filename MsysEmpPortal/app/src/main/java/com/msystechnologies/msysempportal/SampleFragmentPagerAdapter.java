package com.msystechnologies.msysempportal;

/**
 * Created by pravinth on 21/1/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by pravinth on 20/1/16.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Basic Info", "Employee","Additional"};
    private Context context;
    private FragmentManager fm;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.fm = fm;
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                BasicFragment tab1 = new BasicFragment();
                return tab1;
            case 1:
                EmployeeFragment tab2 = new EmployeeFragment();
                return tab2;
            case 2:
                AdditionalFragment tab3 = new AdditionalFragment();
                return tab3;
            default:
                return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

