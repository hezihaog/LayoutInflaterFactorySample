package oms.mmc.sample;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Package: oms.mmc.sample
 * FileName: FontTextView
 * Date: on 2018/3/7  下午10:08
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class FontTextView extends TextView {
    private Typeface mTypeface;

    public FontTextView(Context context) {
        super(context);
        init();
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        createTextTypeface();
        setTypeface(mTypeface);
    }

    private void createTextTypeface() {
        mTypeface = Typeface.createFromAsset(getContext().getAssets(), "song.ttf");
    }
}