package pk.databinddemo.listview;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pk.databinddemo.R;
import pk.databinddemo.User;
import pk.databinddemo.databinding.ActivityMainBinding;
import pk.databinddemo.databinding.ActivityUserBinding;

/**
 * @author zijiao
 * @version 2016/3/8
 * @Mark
 */
public class UserActivity extends Activity {

    private ListView mListView;
    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        ActivityMainBinding as = ActivityMainBinding.inflate(getLayoutInflater());
        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new UserAdapter(this);
        mListView.setAdapter(mAdapter);

        binding.setListener(new IUserListener() {
            @Override
            public void onSetData(View view) {
                List<User> data = new ArrayList<>();
                Random r = new Random();
                for (int i = 0; i < 100; i++) {
                    data.add(new User(r.nextInt(10) + "username", r.nextFloat() + "password"));
                }
                mAdapter.setData(data);
            }

            @Override
            public void getChildAt(View view) {
                try {
                    View v = mListView.getChildAt(1);
                    Log.i("PPPP", v.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
