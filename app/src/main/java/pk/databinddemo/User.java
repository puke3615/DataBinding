package pk.databinddemo;

import android.databinding.BaseObservable;

/**
 * @author zijiao
 * @version 2016/3/7
 * @Mark
 */
public class User extends BaseObservable {

    public String username;

    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
