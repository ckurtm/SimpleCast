package com.peirr.cast.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.peirra.cast.CastContract;
import com.peirra.cast.CastPresenter;

public class MainActivity extends AppCompatActivity implements CastContract.View {

    private static final String TAG = "MainActivity";
    private Button button;
    private CastPresenter presenter;
    private String MESSAGE = "{  \n" +
            "   \"typ\":\"VIDEO\",\n" +
            "   \"state\":\"PLAY\",\n" +
            "   \"version\":1,\n" +
            "   \"data\":{  \n" +
            "      \"url\":\"http://www.peirr.com/black.mp4\"\n" +
            "   }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        presenter = new CastPresenter(Injection.provideCastDevice(this,CastOptionsProvider.CUSTOM_NAMESPACE));
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                presenter.post(MESSAGE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.cast, menu);
        presenter.attachMenu(menu, R.id.media_route_menu_item);
        return true;
    }


    private void setupActionBar() {
        final Toolbar mToolbar = (Toolbar) findViewById(com.peirra.cast.R.id.toolbar);
        mToolbar.setTitle(com.peirra.cast.R.string.app_name);
        setSupportActionBar(mToolbar);
    }

    @Override
    public void showCastConnected() {
        Log.d(TAG, "showCastConnected() : " + "");
        button.setVisibility(View.VISIBLE);
        invalidateOptionsMenu();
    }

    @Override
    public void showCastDisconnected() {
        Log.d(TAG, "showCastDisconnected() : " + "");
        button.setVisibility(View.GONE);
        invalidateOptionsMenu();
    }

    @Override
    public void showMessageReceived(final String nameSpace, final String json) {
        Log.d(TAG, "showMessageReceived() : " + "nameSpace = [" + nameSpace + "], json = [" + json + "]");
    }
}

