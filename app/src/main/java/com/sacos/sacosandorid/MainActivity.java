package com.sacos.sacosandorid;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.facebook.stetho.Stetho;

import net.danlew.android.joda.JodaTimeAndroid;

public class MainActivity extends AppCompatActivity implements ExploreActivity.OnLoadingListener {

  private ProgressBar mProgressBar;
  private DrawerLayout mDrawer;
  private Toolbar toolbar;
  private ActionBarDrawerToggle mDrawerToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    JodaTimeAndroid.init(this);

    Stetho.initializeWithDefaults(this);

    setContentView(R.layout.activity_main);
    // Set a Toolbar to replace the ActionBar.
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer,toolbar ,  R.string.drawer_open, R.string.drawer_close) {

      /** Called when a drawer has settled in a completely closed state. */
      public void onDrawerClosed(View view) {
        super.onDrawerClosed(view);
        getActionBar().setTitle(R.string.explore_page_title);
      }

      /** Called when a drawer has settled in a completely open state. */
      public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        getActionBar().setTitle(R.string.drawer_page_title);
        //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
      }
    };

    mDrawerToggle.syncState();

    mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(R.id.explore_container, new ExploreActivity())
          .commit();
    }

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // The action bar home/up action should open or close the drawer.
    switch (item.getItemId()) {
      case android.R.id.home:
        mDrawer.openDrawer(GravityCompat.START);
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.drawer_menu, menu);
    return true;
  }


  @Override
  public void onLoadingStarted() {
    mProgressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void onLoadingFinished() {
    mProgressBar.setVisibility(View.GONE);
  }

}
