package com.demo.example.neonkeyboard.ledkeyboard.MyGif.presenter.impl;

import android.text.TextUtils;
import com.demo.example.neonkeyboard.ledkeyboard.MyGif.presenter.IGifSearchPresenter;
import com.demo.example.neonkeyboard.ledkeyboard.MyGif.presenter.IGifSearchView;
import com.tenor.android.core.network.ApiClient;
import com.tenor.android.core.presenter.impl.BasePresenter;
import com.tenor.android.core.response.BaseError;
import com.tenor.android.core.constant.MediaFilter;
import com.tenor.android.core.response.impl.GifsResponse;
import retrofit2.Call;


public class GifSearchPresenter extends BasePresenter<IGifSearchView> implements IGifSearchPresenter {
    public GifSearchPresenter(IGifSearchView iGifSearchView) {
        super(iGifSearchView);
    }

    @Override 
    public Call<GifsResponse> search(String str, int i, String str2, final boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        Call<GifsResponse> search = ApiClient.getInstance(getView().getContext()).search(ApiClient.getServiceIds(getView().getContext()), str, i, str2, MediaFilter.BASIC, "");
        search.enqueue(new AppWeakRefCallback<IGifSearchView, GifsResponse>(getWeakRef()) {
            public void success(IGifSearchView iGifSearchView, GifsResponse gifsResponse) {
                if (gifsResponse == null) {
                    iGifSearchView.onReceiveSearchResultsFailed(new BaseError(), z);
                } else {
                    iGifSearchView.onReceiveSearchResultsSucceed(gifsResponse, z);
                }
            }

            public void failure(IGifSearchView iGifSearchView, Throwable t) {
                iGifSearchView.onReceiveSearchResultsFailed(new BaseError(t != null ? t.getMessage() : null), z);
            }
        });
        return search;
    }
}
