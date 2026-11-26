package com.tenor.android.core.weakref;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;

/**
 * Local replacement for com.tenor.android.core.weakref.WeakRefOnScrollListener,
 * which was removed from tenor-android-core in 0.5.1 (upstream 0.5.0 is
 * unavailable on public repositories). Holds a weak reference to the host so
 * callbacks do not leak the popup/activity.
 */
public abstract class WeakRefOnScrollListener<T> extends RecyclerView.OnScrollListener {

    private final WeakReference<T> mWeakRef;

    public WeakRefOnScrollListener(T ref) {
        mWeakRef = new WeakReference<>(ref);
    }

    public T getRef() {
        return mWeakRef == null ? null : mWeakRef.get();
    }
}
