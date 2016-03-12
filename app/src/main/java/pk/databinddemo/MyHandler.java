package pk.databinddemo;

import android.view.View;

import java.util.Random;

import pk.databinddemo.databinding.ActivityMainBinding;

/**
 * @author zijiao
 * @version 2016/3/8
 * @Mark
 */
public class MyHandler implements IEventListener {

    private final ActivityMainBinding mBinding;

    public MyHandler(ActivityMainBinding binding) {
        this.mBinding = binding;
    }

    public void onChangeText(View view) {
        Random r = new Random();
        User user = new User("username " + r.nextInt(10), "password " + r.nextBoolean());
        mBinding.setUser(user);
    }

    public void onToList(View view) {

    }

    @Override
    public void onToGoods(View view) {

    }


}