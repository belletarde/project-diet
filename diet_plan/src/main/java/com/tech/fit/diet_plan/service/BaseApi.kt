package com.tech.fit.diet_plan.service

import com.google.gson.GsonBuilder
import com.tech.fit.diet_plan.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseApi {
    companion object {
        val baseUrl = "https://api.tecnonutri.com.br/api/v4/"
    }

    fun build(url: String? = baseUrl, interceptor: Interceptor? = GeneralInterceptor()): Retrofit {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor(interceptor!!)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        val client = builder.build()

        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(url!!)
                .client(client)
                .addCallAdapterFactory(ApiErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(defaultConverterFactory())

        return retrofitBuilder.build()
    }

    private fun defaultConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }
}