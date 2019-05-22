package com.tech.fit.diet_plan.service

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class GeneralInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = createRequest(original)
        return chain.proceed(request)
    }

    private fun createRequest(original: Request): Request {
        val builder = original.newBuilder()

        addHeader(builder, "X-API-KEY", "62LlF7idCzgLUbEMfyvH3hYAngisxOAekhvR8NPnhJYRjhL50xBh7d8XqnNXynQ9")
        addHeader(builder, "APP_VERSION", "289")
        addHeader(builder, "APP-VERSION", "289")
        addHeader(builder, "LOCALE", "pt")
        addHeader(builder, "LANGUAGE", "pt")
        addHeader(builder, "COUNTRY", "br")
        addHeader(builder, "DEVICE_ID", "1")
        addHeader(builder, "PLATFORM", "Android")

        return builder.build()
    }

    private fun addHeader(builder: Request.Builder?, key: String, value: String?) {
        if (value != null) {
            builder?.addHeader(key, value)
        }
    }
}