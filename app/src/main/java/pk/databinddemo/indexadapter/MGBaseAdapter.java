package pk.databinddemo.indexadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zijiao
 * @version 2016/3/10
 * @Mark
 */
public abstract class MGBaseAdapter<T> extends BaseAdapter {

    protected final Context mContext;
    private final OnVisibleListener mOnVisibleListener;
    private final List<Subject<T>> mDatas;

    public MGBaseAdapter(Context context, OnVisibleListener visibleListener) {
        this.mContext = context;
        this.mDatas = new ArrayList<>();
        this.mOnVisibleListener = visibleListener;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Subject<T> getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<Subject<T>> datas) {
        if (datas == null) {
            return;
        }
        mDatas.clear();
        mDatas.addAll(datas);
        notifyChangeByData();
    }

    public void notifyItemChangeIfNeed(int position) {
        Subject<T> subject = mDatas.get(position);
        if (subject != null) {
            if (mOnVisibleListener != null && !mOnVisibleListener.isVisible(position)) {
                return;
            }
            subject.notifyChange();
        }
    }

    public final void notifyChangeByData() {
        for (Subject<T> subject : mDatas) {
            if (subject != null) {
                subject.notifyChange();
            }
        }
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Layout {
        int value();
    }

    public static abstract class MGHolder {

        protected View mView;

        public MGHolder(Context context) {
            Class cls = getClass();
            int layout;
            if (!cls.isAnnotationPresent(Layout.class)
                    || (layout = ((Layout) cls.getAnnotation(Layout.class)).value()) < 0) {
                throw new RuntimeException("haven`t a layout resource");
            }
            mView = LayoutInflater.from(context).inflate(layout, null);
        }

        public View createView() {
            return mView;
        }
    }

}
