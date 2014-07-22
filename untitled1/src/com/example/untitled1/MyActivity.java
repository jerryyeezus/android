package com.example.untitled1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout sub = (LinearLayout) findViewById(R.id.sub);
        TextView tv = (TextView) findViewById(R.id.tv);
        TextView tv2 = (TextView) sub.findViewById(R.id.tv);
        tv.setText("DF");
        tv2.setText("a");
    }
}
