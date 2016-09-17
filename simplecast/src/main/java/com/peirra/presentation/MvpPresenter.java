package com.peirra.presentation;


public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
