package pk.databinddemo;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

import pk.databinddemo.databinding.ActivityMainBinding;
import pk.databinddemo.indexadapter.goods.GoodsActivity;
import pk.databinddemo.listview.UserActivity;

public class MainActivity extends Activity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
//        mBinding.setListener(new MyHandler(mBinding));
        mBinding.setListener(new IEventListener() {
            @Override
            public void onChangeText(View view) {
                Random r = new Random();
                User user = new User("username " + r.nextInt(10), "password " + r.nextBoolean());
                mBinding.setUser(user);
            }

            @Override
            public void onToList(View view) {
                startActivity(new Intent(MainActivity.this, UserActivity.class));
            }

            @Override
            public void onToGoods(View view) {
                startActivity(new Intent(MainActivity.this, GoodsActivity.class));
            }
        });
    }

}
