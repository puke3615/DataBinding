package pk.databinddemo.listview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import pk.databinddemo.R;
import pk.databinddemo.User;
import pk.databinddemo.databinding.UserItemBinding;

/**
 * @author zijiao
 * @version 2016/3/8
 * @Mark
 */
public class UserAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<User> mDatas;

    public UserAdapter(Context context) {
        this.mContext = context;
        this.mDatas = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public User getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<User> list) {
        mDatas.clear();
        if (list != null && list.size() != 0) {
            mDatas.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        UserItemBinding binding;
        if (view == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.user_item, parent, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (UserItemBinding) view.getTag();
        }
        if (binding != null) {
            binding.setUser(getItem(position));
        }
        return view;
    }

}
