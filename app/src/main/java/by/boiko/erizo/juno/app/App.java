package by.boiko.erizo.juno.app;

import android.app.Application;

import by.boiko.erizo.juno.injection.AppComponent;
import by.boiko.erizo.juno.injection.AppModule;
import by.boiko.erizo.juno.injection.DaggerAppComponent;


public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}