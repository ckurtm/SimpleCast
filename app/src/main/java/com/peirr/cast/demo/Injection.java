package com.peirr.cast.demo;

import android.content.Context;

import com.peirra.cast.CastDevice;
import com.peirra.cast.CastDeviceManager;

/**
 * Created by kurt on 2016/09/15.
 */

public class Injection {

    public static CastDevice provideCastDevice(Context context,String nameSpace){
        return new CastDeviceManager(context, nameSpace);
    }
}
