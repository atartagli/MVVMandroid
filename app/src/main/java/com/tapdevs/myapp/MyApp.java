package com.tapdevs.myapp;

import android.app.Application;

import com.tapdevs.myapp.injections.component.DaggerNetComponent;
import com.tapdevs.myapp.injections.component.NetComponent;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;

import io.realm.Realm;

/**
 * Created by  Jan Shair on 30/01/2017.
 */

public class MyApp extends Application {
    private NetComponent mNetComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("https://api.github.com"))
                .build();
        Realm.init(this);
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
