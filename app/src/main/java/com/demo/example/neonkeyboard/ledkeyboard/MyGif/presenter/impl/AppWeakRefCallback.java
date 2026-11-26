package com.demo.example.neonkeyboard.ledkeyboard.MyGif.presenter.impl;

import com.tenor.android.core.response.WeakRefCallback;
import com.tenor.android.core.view.IBaseView;

/**
 * Adapter for the tenor-android-core 0.5.1 callback shape: lets app code keep
 * expressing failure callbacks as {@code failure(CTX, BaseError)}-style logic
 * while the library now delivers {@code Throwable}.
 */
public abstract class AppWeakRefCallback<CTX extends IBaseView, T> extends WeakRefCallback<CTX, T> {

    public AppWeakRefCallback(CTX ref) {
        super(ref);
    }

    public AppWeakRefCallback(java.lang.ref.WeakReference<CTX> ref) {
        super(ref);
    }
}
