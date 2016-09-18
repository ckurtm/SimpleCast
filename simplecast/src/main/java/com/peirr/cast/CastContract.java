package com.peirr.cast;

import android.view.Menu;

import com.peirr.presentation.MvpPresenter;
import com.peirr.presentation.MvpView;

public interface CastContract {

    interface View extends MvpView {
        void showCastConnected();
        void showCastDisconnected();
        void showMessageReceived(String nameSpace,String json);
    }

    interface Presenter extends MvpPresenter<View> {
        void attach();
        void detach();
        void attachMenu(Menu menu,int menuItemId);
        void post(String json);
    }

}