package com.tech.fit.diet_plan.presenter

import com.tech.fit.diet_plan.Utils.PostThreadExecutor
import com.tech.fit.diet_plan.Utils.ThreadExecutor
import com.tech.fit.diet_plan.Utils.BasePresenter
import com.tech.fit.diet_plan.model.DietPlanDetail
import com.tech.fit.diet_plan.repository.DietPlansRepository
import com.tech.fit.diet_plan.view.DietPlanDetailView
import com.tech.fit.diet_plan.view.DietPlansView
import io.reactivex.rxkotlin.addTo

class DietPlanDetailPresenter (
    subscriberOn: ThreadExecutor,
    observerOn: PostThreadExecutor,
    private val view: DietPlanDetailView,
    private var dietPlansRepository: DietPlansRepository
) : BasePresenter(subscriberOn, observerOn) {

    fun findDietDetail(id: Long) {
        execute(dietPlansRepository.retrieveDietDetail(id)).subscribe({ item ->
            view.setDietDetail(item.result)
        }, { error ->
            view.displayError()
        }).addTo(compositeDisposable)
    }

}