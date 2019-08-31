package com.robj.radicallyreusable.base.mvp.fragment;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by Rob J on 05/02/17.
 */

public abstract class BaseMvpPresenter<V extends BaseMvpView> extends MvpBasePresenter<V> {

    public void onResume() { }

    public void onPause() { }

}
