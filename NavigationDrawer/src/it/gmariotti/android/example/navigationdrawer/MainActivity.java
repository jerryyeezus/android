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
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class MainActivity extends Activity {

    private DrawerLayout mDrawer;
    private CustomActionBarDrawerToggle mDrawerToggle;
    private ViewFlipper mCCFlipper, mCC_TextFlipper, mCC_BackgroundFlipper;

    private LinearLayout mTextPage;
    private Switch mCCEnableSwitch;
    private Switch mCCAndroid;
    private LinearLayout mCCBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        initCaptionsDrawer();
        initFonts();
    }

    private void initFonts() {
        TextView courier = (TextView) ((ViewGroup) findViewById(R.id.courier)).getChildAt(0);
        courier.setTypeface(AppConstants.CC_Serif_Mono(getApplicationContext()));

        TextView europa = (TextView) ((ViewGroup) findViewById(R.id.europa)).getChildAt(0);
        europa.setTypeface(AppConstants.CC_Serif_Prop(getApplicationContext()));

        TextView frutiger_mono = (TextView) ((ViewGroup) findViewById(R.id.frutiger_mono))
                .getChildAt(0);
        frutiger_mono.setTypeface(AppConstants.CC_Sans_Mono(getApplicationContext()));

        TextView frutiger = (TextView) ((ViewGroup) findViewById(R.id.frutiger)).getChildAt(0);
        frutiger.setTypeface(AppConstants.CC_Sans_Mono(getApplicationContext()));

        TextView dom_casual = (TextView) ((ViewGroup) findViewById(R.id.dom_casual)).getChildAt(0);
        dom_casual.setTypeface(AppConstants.CC_Casual(getApplicationContext()));

        TextView kaufmann = (TextView) ((ViewGroup) findViewById(R.id.kaufmann)).getChildAt(0);
        kaufmann.setTypeface(AppConstants.CC_Cursive(getApplicationContext()));

        TextView gothic = (TextView) ((ViewGroup) findViewById(R.id.gothic)).getChildAt(0);
        gothic.setTypeface(AppConstants.CC_Small_Caps(getApplicationContext()));
    }

    private void initCaptionsDrawer() {
        Animation slide_in_right = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation slide_out_left = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawer.setDrawerListener(mDrawerToggle);

        mDrawerToggle = new CustomActionBarDrawerToggle(this, mDrawer);

        mCCFlipper = (ViewFlipper) findViewById(R.id.flipper);
        mCC_TextFlipper = (ViewFlipper) mCCFlipper.getChildAt(1).findViewById(R.id.flipper);
        mCC_BackgroundFlipper = (ViewFlipper) mCCFlipper.getChildAt(2).findViewById(R.id.flipper);

        mTextPage = (LinearLayout) findViewById(R.id.cc_page_text);
        mTextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCCFlipper.setDisplayedChild(1);
                resetFlipper();
            }
        });

        mCCEnableSwitch = (Switch) findViewById(R.id.switch_cc_enable);
        mCCAndroid = (Switch) findViewById(R.id.switch_cc_android);
        mCCAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableRelevantButtons();
                v.invalidate();
            }
        });
        mCCEnableSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                enableRelevantButtons();
                v.invalidate();
            }
        });

        for (int i = 0; i < mCCFlipper.getChildCount(); i++) {
            final ViewGroup flipper = (ViewGroup) mCCFlipper.getChildAt(i)
                    .findViewById(R.id.flipper);
            if (flipper != null) {
                for (int j = 0; j < flipper.getChildCount(); j++) {
                    LinearLayout back = (LinearLayout) getLayoutInflater()
                            .inflate(R.layout._back, null);
                    back.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            if (mCC_BackgroundFlipper.getDisplayedChild() > 0) {
                                mCC_BackgroundFlipper.setDisplayedChild(0);
                            } else if (mCC_TextFlipper.getDisplayedChild() > 0) {
                                mCC_TextFlipper.setDisplayedChild(0);
                            } else {
                                mCCFlipper.setDisplayedChild(0);
                            }
                        }
                    });
                    final ViewGroup subView = (ViewGroup) flipper.getChildAt(j);

                    for (int k = 0; k < subView.getChildCount(); k++) {
                        View leafView = subView.getChildAt(k);
                        if (leafView instanceof LinearLayout) {
                            if (subView.getId() == R.id.leaf) {
                                leafView.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        switch (v.getId()) {
                                            case R.id.cc_page_text_color_white:

                                                break;
                                        }
                                        TextView textView = (TextView) ((ViewGroup) v).getChildAt(0);
                                        String whichSetting = mCC_BackgroundFlipper.getDisplayedChild() > 0 ? "Caption Background" : "Caption Text";

                                        Toast.makeText(getApplicationContext(), whichSetting + " has been set to " + textView.getText(),
                                                Toast.LENGTH_LONG).show();
                                        ((ViewFlipper) flipper).setDisplayedChild(0);
                                    }
                                });
                            } else {
                                final int leafIndex = k / 2 + 1;
                                leafView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        ((ViewFlipper) flipper).setDisplayedChild(leafIndex);
                                    }
                                });
                            }
                        }
                    }

                    subView.addView(back);
                }
            }
        }

        mCCFlipper.setInAnimation(slide_in_right);
        mCCFlipper.setOutAnimation(slide_out_left);

        mCCBackground = (LinearLayout) findViewById(R.id.cc_page_background);
        mCCBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCCFlipper.setDisplayedChild(2);
            }
        });

        enableRelevantButtons();
    }

    private void resetFlipper() {
        for (int i = 0; i < mCCFlipper.getChildCount(); i++) {
            final ViewFlipper flipper = (ViewFlipper) mCCFlipper.getChildAt(i)
                    .findViewById(R.id.flipper);
            if (flipper != null) {
                flipper.setDisplayedChild(0);
            }
        }
    }

    private void enableRelevantButtons() {
        boolean shouldEnableAndroid = false;
        boolean shouldEnableCustom = false;
        if (mCCEnableSwitch.isChecked() && !mCCAndroid.isChecked()) {
            shouldEnableAndroid = true;
            shouldEnableCustom = true;
        } else if (mCCEnableSwitch.isChecked() && mCCAndroid.isChecked()) {
            shouldEnableAndroid = true;
            shouldEnableCustom = false;
        }
        mCCAndroid.setEnabled(shouldEnableAndroid);
        mTextPage.setEnabled(shouldEnableCustom);
        mTextPage.getChildAt(0).setEnabled(shouldEnableCustom);
        mCCBackground.setEnabled(shouldEnableCustom);
        mCCBackground.getChildAt(0).setEnabled(shouldEnableCustom);

        mTextPage.invalidate();
        mCCAndroid.invalidate();
    }

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
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
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
