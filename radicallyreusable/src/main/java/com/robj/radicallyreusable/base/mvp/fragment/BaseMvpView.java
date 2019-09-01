package com.robj.radicallyreusable.base.mvp.fragment;


import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by Rob J on 05/02/17.
 */

public interface BaseMvpView extends MvpView {

    void showProgressDialog(int stringResId);

    void hideProgressDialog();

    void showErrorDialog(int errorResId);

    void showToast(int stringResId);
}
