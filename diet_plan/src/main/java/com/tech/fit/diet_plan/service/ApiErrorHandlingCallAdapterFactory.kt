package com.tech.fit.diet_plan.service

import io.reactivex.Single
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.lang.reflect.Type

class ApiErrorHandlingCallAdapterFactory : CallAdapter.Factory() {

    private val original: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    /**
     * Create an instance of ApiErrorHandlingCallAdapterFactory
     *
     * @return a factory object
     */

    companion object {
        fun create() : CallAdapter.Factory = ApiErrorHandlingCallAdapterFactory()
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(returnType: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): CallAdapter<in Any, out Any>? {
        return RxCallAdapterWrapper(original.get(returnType!!, annotations!!, retrofit!!) as CallAdapter<in Any, out Any>)
    }

    private class RxCallAdapterWrapper internal constructor(private val wrapped: CallAdapter<in Any, out Any>) : CallAdapter<Any, Single<Any>> {

        override fun responseType(): Type {
            return wrapped.responseType()!!
        }

        @Suppress("UNCHECKED_CAST")
        override fun adapt(call: retrofit2.Call<Any>): Single<Any> {
            return (wrapped.adapt(call) as Single<Any>).onErrorResumeNext { Single.error(ApiExceptionMapper.map(it)) }
        }

    }

}