package pk.databinddemo;

import android.app.Application;
import android.os.StrictMode;

/**
 * @author zijiao
 * @version 2016/3/8
 * @Mark
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.enableDefaults();
    }
}
