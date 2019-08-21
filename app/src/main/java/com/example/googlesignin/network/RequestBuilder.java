package com.example.googlesignin.network;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public final class RequestBuilder {

    // No need to instantiate this class.
    private RequestBuilder() {
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        return createService(serviceClass, baseUrl, null);
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl, final AccessToken accessToken) {
        OkHttpClient okHttpClient;
        if(accessToken==null) {
            okHttpClient = new OkHttpClient().newBuilder().connectionSpecs(Arrays.asList(
                    ConnectionSpec.MODERN_TLS,
                    ConnectionSpec.COMPATIBLE_TLS,
                    ConnectionSpec.CLEARTEXT)).build();
        } else {
            okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();

                    Request.Builder builder = originalRequest.newBuilder()
                            .addHeader("Content-productType", "application/json")
                            .addHeader("Accept", "application/json;versions=1")
                            .addHeader("Authorization", accessToken.getTokenType() +
                                    " " + accessToken.getAccessToken());

                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
                }
            }).build();
        }

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        return builder.create(serviceClass);
    }
}
