package com.demo.example.neonkeyboard.ledkeyboard.MyGif.presenter.impl;

import com.demo.example.neonkeyboard.ledkeyboard.MyGif.presenter.ITrendingPresenter;
import com.demo.example.neonkeyboard.ledkeyboard.MyGif.presenter.ITrendingView;
import com.tenor.android.core.network.ApiClient;
import com.tenor.android.core.presenter.impl.BasePresenter;
import com.tenor.android.core.response.BaseError;
import com.tenor.android.core.constant.MediaFilter;
import com.tenor.android.core.response.impl.TrendingGifResponse;
import retrofit2.Call;


public class TrendingPresenter extends BasePresenter<ITrendingView> implements ITrendingPresenter {
    public TrendingPresenter(ITrendingView iTrendingView) {
        super(iTrendingView);
    }

    @Override 
    public Call<TrendingGifResponse> getTrending(int i, String str, final boolean z) {
        Call<TrendingGifResponse> trending = ApiClient.getInstance(getView().getContext()).getTrending(ApiClient.getServiceIds(getView().getContext()), Integer.valueOf(i), str, MediaFilter.BASIC, "");
        trending.enqueue(new AppWeakRefCallback<ITrendingView, TrendingGifResponse>(getWeakRef()) {
            public void success(ITrendingView iTrendingView, TrendingGifResponse trendingGifResponse) {
                if (trendingGifResponse == null) {
                    iTrendingView.onReceiveSearchResultsFailed(new BaseError(), z);
                } else {
                    iTrendingView.onReceiveSearchResultsSucceed(trendingGifResponse, z);
                }
            }

            public void failure(ITrendingView iTrendingView, Throwable t) {
                iTrendingView.onReceiveSearchResultsFailed(new BaseError(t != null ? t.getMessage() : null), z);
            }
        });
        return trending;
    }
}
