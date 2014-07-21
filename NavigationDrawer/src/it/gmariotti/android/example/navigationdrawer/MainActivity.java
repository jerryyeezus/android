/*******************************************************************************
 * Copyright 2013 Gabriele Mariotti
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package it.gmariotti.android.example.navigationdrawer;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    ViewFlipper mCCFlipper;
    LinearLayout mAppearancePage;
    ViewFlipper ccFlipper ;
    private DrawerLayout mDrawer;
    private CustomActionBarDrawerToggle mDrawerToggle;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
//
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerToggle = new CustomActionBarDrawerToggle(this, mDrawer);
        mDrawer.setDrawerListener(mDrawerToggle);
        mCCFlipper = (ViewFlipper) findViewById(R.id.ccFlipper);

        mAppearancePage = (LinearLayout) findViewById(R.id.cc_appearance);
        mAppearancePage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mCCFlipper.showNext();
            }
        });

        Animation slide_in_right = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation slide_out_left = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);

        mCCFlipper.setInAnimation(slide_in_right);
        //set the animation for the view leaving th screen
        mCCFlipper.setOutAnimation(slide_out_left);


    }

//    private void _initMenu() {
//        NsMenuAdapter mAdapter = new NsMenuAdapter(this);
//
//        // Add Header
//        mAdapter.addHeader(R.string.ns_menu_main_header);
//
//        // Add first block
//
//        menuItems = getResources().getStringArray(
//                R.array.ns_menu_items);
//        String[] menuItemsIcon = getResources().getStringArray(
//                R.array.ns_menu_items_icon);
//
//        int res = 0;
//        for (String item : menuItems) {
//
//            int id_title = getResources().getIdentifier(item, "string",
//                    this.getPackageName());
//            int id_icon = getResources().getIdentifier(menuItemsIcon[res],
//                    "drawable", this.getPackageName());
//            int id_type = getResources().obtainTypedArray(R.array.ns_menu_types).getInt(res, 0);
//
//            NsMenuItemModel mItem = new NsMenuItemModel(id_title, id_icon, false, 90, id_type);
//            mAdapter.addItem(mItem);
//            res++;
//        }
//
//        mAdapter.addHeader(R.string.ns_menu_main_header2);
//
//        mDrawerList = (ListView) findViewById(R.id.drawer);
//        if (mDrawerList != null)
//            mDrawerList.setAdapter(mAdapter);
//
//
//    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
//        boolean drawerOpen = mDrawer.isDrawerOpen(mDrawerList);
//        menu.findItem(R.id.action_save).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
         * The action bar home/up should open or close the drawer.
		 * ActionBarDrawerToggle will take care of this.
		 */
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    private class CustomActionBarDrawerToggle extends ActionBarDrawerToggle {

        public CustomActionBarDrawerToggle(Activity mActivity, DrawerLayout mDrawerLayout) {
            super(
                    mActivity,
                    mDrawerLayout,
                    R.drawable.ic_drawer,
                    R.string.ns_menu_open,
                    R.string.ns_menu_close);
        }

        @Override
        public void onDrawerClosed(View view) {
            getActionBar().setTitle(getString(R.string.ns_menu_close));
            invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            getActionBar().setTitle(getString(R.string.ns_menu_open));
            invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
        }
    }


}
