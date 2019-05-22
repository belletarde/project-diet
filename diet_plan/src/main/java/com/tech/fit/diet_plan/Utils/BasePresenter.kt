package com.tech.fit.diet_plan.Utils

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter (private val subscriberOn: ThreadExecutor,
                                              private val observerOn: PostThreadExecutor
) {

    protected var compositeDisposable = CompositeDisposable()

    open fun destroy() {
        compositeDisposable.dispose()
    }


    protected fun  <Any> execute(single: Single<Any>): Single<Any> {
        return single
                .subscribeOn(subscriberOn.scheduler)
                .observeOn(observerOn.scheduler)
    }

}