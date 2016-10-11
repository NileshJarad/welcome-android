package com.stephentuso.welcome;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by stephentuso on 11/16/15.
 * An extension of {@link SimpleViewPagerIndicator SimpleViewPagerIndicator} that implements
 * the setup method of {@link OnWelcomeScreenPageChangeListener OnWelcomeScreenPageChangeListener}
 */
public class WelcomeScreenViewPagerIndicator extends SimpleViewPagerIndicator implements OnWelcomeScreenPageChangeListener {

    public WelcomeScreenViewPagerIndicator(Context context) {
        super(context);
    }

    public WelcomeScreenViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WelcomeScreenViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setup(WelcomeConfiguration config) {
        setTotalPages(config.viewablePageCount());
        if (config.isRtl()) {
            setRtl(true);
            if (config.getSwipeToDismiss()) {
                setPageIndexOffset(-1);
            }
        }
    }
}