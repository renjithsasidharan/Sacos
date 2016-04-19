package com.sacos.sacosandorid;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by renjith on 26/03/16.
 */
public class BrowseDatesActivty extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activty_browsedates);
//    Toolbar toolbar = (Toolbar) findViewById(R.id.browse_dates_toolbar);
//    setSupportActionBar(toolbar);
//
//    TabLayout tabLayout = (TabLayout) findViewById(R.id.browse_dates_tab_layout);
//    tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//    tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//    Bundle extras = getIntent().getExtras();
//    if(extras == null){
//      return;
//    }
//
//    Bundle args = new Bundle();
//    args.putString("fromAirportCode", extras.getString("fromAirportCode"));
//    args.putString("toAirportCode", extras.getString("toAirportCode"));
//
//    final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//    final PagerAdapter adapter = new BrowseDatesPagerAdapter
//        (getSupportFragmentManager(), tabLayout.getTabCount(), args);
//
//    viewPager.setAdapter(adapter);
//    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//      @Override
//      public void onTabSelected(TabLayout.Tab tab) {
//        viewPager.setCurrentItem(tab.getPosition());
//      }
//
//      @Override
//      public void onTabUnselected(TabLayout.Tab tab) {
//
//      }
//
//      @Override
//      public void onTabReselected(TabLayout.Tab tab) {
//
//      }
//    });
  }
}
