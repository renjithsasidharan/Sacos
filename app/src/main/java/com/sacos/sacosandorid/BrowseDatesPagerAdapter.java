package com.sacos.sacosandorid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by renjith on 25/03/16.
 */
public class BrowseDatesPagerAdapter extends FragmentStatePagerAdapter {
  int mNumOfTabs;
  private Bundle args;

  public BrowseDatesPagerAdapter(FragmentManager fm, int NumOfTabs, Bundle args) {
    super(fm);
    this.mNumOfTabs = NumOfTabs;
    this.args = args;
  }

  @Override
  public Fragment getItem(int position) {

    switch (position) {
      case 0:
        BrowseDatesFragment tab1 = new BrowseDatesFragment();
        tab1.setArguments(args);
        return tab1;
      case 1:
        BrowseDatesBestQuotesFragment tab2 = new BrowseDatesBestQuotesFragment();
        return tab2;
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return mNumOfTabs;
  }
}
