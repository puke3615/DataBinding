package pk.databinddemo.indexadapter;

/**
 * @author zijiao
 * @version 2016/3/10
 * @Mark
 */
public class Subject<T> {

    private OnDataChangeListener<T> mChangeListener;

    private T mData;

    private boolean mChange = false;

    private Subject(T data) {
        this.mData = data;
    }

    public static <T> Subject create(T data) {
        return new Subject(data);
    }

    public void setOnDataChangeListener(OnDataChangeListener<T> listener) {
        this.mChangeListener = listener;
    }

    public void setData(T data) {
        this.mData = data;
        notifyChange();
    }

    public T getData() {
        return mData;
    }

    public void notifyChange() {
        if (mChangeListener != null) {
            mChangeListener.onChange(mData);
        }
    }


}
