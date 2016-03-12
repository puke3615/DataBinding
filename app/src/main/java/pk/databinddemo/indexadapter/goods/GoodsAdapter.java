package pk.databinddemo.indexadapter.goods;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pk.databinddemo.R;
import pk.databinddemo.indexadapter.MGBaseAdapter;
import pk.databinddemo.indexadapter.OnDataChangeListener;
import pk.databinddemo.indexadapter.OnVisibleListener;
import pk.databinddemo.indexadapter.Subject;

/**
 * @author zijiao
 * @version 2016/3/10
 * @Mark
 */
public class GoodsAdapter extends MGBaseAdapter<Goods> {

    public GoodsAdapter(Context context, OnVisibleListener visibleListener) {
        super(context, visibleListener);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //find or bind holder
        GoodsHolder holder;
        if (view == null) {
            holder = new GoodsHolder(mContext);
            view = holder.createView();
            view.setTag(holder);
        } else {
            holder = (GoodsHolder) view.getTag();
        }

        //check data
        Subject<Goods> subject;
        if (holder != null && (subject = getItem(position)) != null) {
            //get data
            Goods goods = subject.getData();

            //set view
            holder.name.setText(goods.name);
            holder.price.setText(goods.price + "");

            //set watcher
            final View v = view;
            subject.setOnDataChangeListener(new OnDataChangeListener<Goods>() {
                @Override
                public void onChange(Goods data) {
                    GoodsHolder holder = (GoodsHolder) v.getTag();
                    //set view
                    holder.name.setText(data.name);
                    holder.price.setText(data.price + "");
                }
            });
        }

        return view;
    }

    @Layout(R.layout.item_goods)
    private static class GoodsHolder extends MGHolder {
        TextView name, price;

        public GoodsHolder(Context context) {
            super(context);
            name = (TextView) mView.findViewById(R.id.goods_name);
            price = (TextView) mView.findViewById(R.id.goods_price);
        }

    }

}
