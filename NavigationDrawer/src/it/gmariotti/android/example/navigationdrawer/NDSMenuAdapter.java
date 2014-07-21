package it.gmariotti.android.example.navigationdrawer;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JY on 7/20/2014.
 */
public class NDSMenuAdapter extends PagerAdapter {
    private Context mContext;

    public NDSMenuAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.cc_page_main, null);
        container.addView(view, 0);
        return view;
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;

    }
}
