package com.peirr.cast.demo;

import android.content.Context;

import com.peirr.cast.CastDevice;
import com.peirr.cast.CastDeviceManager;

/**
 * Created by kurt on 2016/09/15.
 */

public class Injection {

    public static CastDevice provideCastDevice(Context context,String nameSpace){
        return new CastDeviceManager(context, nameSpace);
    }
}
