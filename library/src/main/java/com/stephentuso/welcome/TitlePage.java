package com.stephentuso.welcome;

import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;

import com.stephentuso.welcome.ui.fragments.WelcomeTitleFragment;

/**
 * A page with a large title and an image
 *
 * Created by stephentuso on 10/11/16.
 */
public class TitlePage extends WelcomePage {

    private int drawableResId;
    private String title;
    private boolean showParallax = true;
    private String titleTypefacePath = null;

    private WelcomeTitleFragment fragment;

    /**
     * A page with a large title and an image
     *
     * @param drawableResId The resource id of the drawable to show
     * @param title Title
     */
    public TitlePage(@DrawableRes int drawableResId, String title) {
        this.drawableResId = drawableResId;
        this.title = title;
    }

    /**
     * Whether or not a parallax effect should be shown.
     * If true, the image will move at a faster rate than the text
     *
     * Default: true
     *
     * @param showParallax If parallax effect should be shown
     *
     * @return This TitlePage object to allow method calls to be chained
     */
    public TitlePage parallax(boolean showParallax) {
        this.showParallax = showParallax;
        return this;
    }

    /**
     * Set the typeface of the title
     *
     * @param typefacePath The path to a typeface in the assets folder
     *
     * @return This TitlePage object to allow method calls to be chained
     */
    public TitlePage titleTypeface(String typefacePath) {
        this.titleTypefacePath = typefacePath;
        return this;
    }

    @Override
    public void setup(WelcomeConfiguration config) {
        super.setup(config);

        if (this.titleTypefacePath == null) {
            titleTypeface(config.getDefaultHeaderTypefacePath());
        }

    }

    @Override
    public Fragment getFragment() {
        return fragment;
    }

    @Override
    public Fragment createFragment() {
        this.fragment = WelcomeTitleFragment.newInstance(drawableResId, title, showParallax, titleTypefacePath);
        return fragment;
    }


}