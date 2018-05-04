package com.zxn.mytest.api;

import com.zxn.mytest.model.NewsInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiServer {

    //http://litchiapi.jstv.com/api/GetFeeds?column=4&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41
    String BASE_URL = "http://litchiapi.jstv.com";
    String URL = "http://litchiapi.jstv.com/api/GetFeeds?column=4&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";

    @GET()
    Call<NewsInfo> getNewsInfo(@Url String url);
}
