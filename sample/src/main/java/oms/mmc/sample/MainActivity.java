package oms.mmc.sample;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Typeface mTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        createTextTypeface();
        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                //动态替换成带字体的TextView
                if (name.equals("TextView")) {
                    return new FontTextView(MainActivity.this, attrs);
                }
                //为了让AppCompat的控件替换到，所以调用AppCompat的替换进行替换
                View view = getDelegate().createView(parent, name, context, attrs);
                if (view != null && view instanceof TextView) {
                    ((TextView) view).setTypeface(mTypeface);
                }
                return view;
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void createTextTypeface() {
        mTypeface = Typeface.createFromAsset(getAssets(), "QingXinKaiTi.ttf");
    }
}