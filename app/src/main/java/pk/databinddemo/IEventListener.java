package pk.databinddemo;

import android.view.View;

/**
 * @author zijiao
 * @version 2016/3/8
 * @Mark 事件传递接口
 */
public interface IEventListener {

    void onChangeText(View view);

    void onToList(View view);

    void onToGoods(View view);


}
