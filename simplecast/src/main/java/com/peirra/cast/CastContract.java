package com.peirra.cast;

import android.view.Menu;

import com.peirra.presentation.MvpPresenter;
import com.peirra.presentation.MvpView;

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