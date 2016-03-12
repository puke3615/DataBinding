package pk.databinddemo.indexadapter.goods;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pk.databinddemo.R;
import pk.databinddemo.indexadapter.OnVisibleListener;
import pk.databinddemo.indexadapter.Subject;

/**
 * @author zijiao
 * @version 2016/3/10
 * @Mark
 */
public class GoodsActivity extends Activity {

    private static final int HEAD_SIZE = 20;
    private static final int ITEM_SIZE = 20;

    private EditText mInput;
    private ListView mListView;
    private GoodsAdapter mAdapter;
    private List<Subject<Goods>> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        mInput = (EditText) findViewById(R.id.input);
        mListView = (ListView) findViewById(R.id.listView);
        addHeadView(HEAD_SIZE);
        mAdapter = new GoodsAdapter(this,
//                null
                new OnVisibleListener() {
                    @Override
                    public boolean isVisible(int position) {
                        int headCount = mListView.getHeaderViewsCount();
                        int first = mListView.getFirstVisiblePosition() - headCount;
                        if (first < 0) {
                            first = 0;
                        }
                        int last = mListView.getLastVisiblePosition() - headCount;

                        int childCount = mListView.getChildCount();

//                        ListAdapter adapter = mListView.getAdapter();
//                        if (adapter instanceof HeaderViewListAdapter) {
//                            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
//                            int headerCount = headerViewListAdapter.getHeadersCount();
//                            first = first - headerCount;
//                            if (first < 0) {
//                                first = 0;
//                            }
//                        }

                        return position >= first && position <= last;
                    }
                }
        );
        mListView.setAdapter(mAdapter);

        mDatas = new ArrayList<>();
        for (int i = 0; i < ITEM_SIZE; i++) {
            Goods goods = new Goods();
            goods.name = String.format("name %d", i);
            goods.price = i;
            mDatas.add(Subject.create(goods));
        }
        mAdapter.setData(mDatas);
    }

    private void addHeadView(int count) {
        for (int i = 0; i < count; i ++) {
            TextView text = new TextView(this);
            text.setText("HeadView " + i);
            mListView.addHeaderView(text);
        }
    }

    public void changeData(View view) {
        Random r = new Random();
        int target = 0;
        try {
            target = Integer.parseInt(mInput.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //change dtaa
        Subject<Goods> subject = mDatas.get(target);
        subject.getData().name = r.nextFloat() + "";

        //notify single
        mAdapter.notifyItemChangeIfNeed(target);


        // notify all
//        mAdapter.notifyChangeByData();


//        mInput.setText(r.nextInt(SIZE) + "");
    }

}
