package com.pd.mufc.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MUFCApiService {

    /**
     * creating an interceptor to add a header for auth token
     */
    class AuthInterceptor(private val token: String): Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request.newBuilder().addHeader("X-Auth-token", token).build()
            return chain.proceed(request)
        }
    }

    /**
     * adding the logging interceptor
     */
    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val clientBuilder = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor("61d2613e12494ec8a92f882361bc23e7"))
        // .addInterceptor(httpLoggingInterceptor)
        .build()

    // still keeping this as lazy but is not required
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.football-data.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(clientBuilder)
            .build()
    }

    val apiInterface: MUFCApiInterface = retrofit.create(MUFCApiInterface::class.java)
}