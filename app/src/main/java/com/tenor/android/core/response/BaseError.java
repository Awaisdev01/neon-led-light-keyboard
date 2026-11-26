package com.tenor.android.core.response;

import java.io.Serializable;

/**
 * Local replacement for com.tenor.android.core.response.BaseError, which was
 * removed from tenor-android-core in 0.5.1 (upstream 0.5.0 is unavailable on
 * public repositories). Keeps the 0.5.0 API surface the app code relies on.
 */
public class BaseError implements Serializable {

    private static final long serialVersionUID = 42L;

    private String mMessage;
    private int mCode;

    public BaseError() {
    }

    public BaseError(String message) {
        mMessage = message;
    }

    public BaseError(int code, String message) {
        mCode = code;
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }

    public int getCode() {
        return mCode;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public void setCode(int code) {
        mCode = code;
    }
}
