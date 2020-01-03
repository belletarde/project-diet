package belletarde.tech.fit.diet_plan.presenter

import belletarde.tech.fit.diet_plan.Utils.PostThreadExecutor
import belletarde.tech.fit.diet_plan.Utils.ThreadExecutor
import belletarde.tech.fit.diet_plan.Utils.BasePresenter
import belletarde.tech.fit.diet_plan.repository.DietPlansRepository
import belletarde.tech.fit.diet_plan.view.DietPlansView
import io.reactivex.rxkotlin.addTo

class DietPlansPresenter (
    subscriberOn: ThreadExecutor,
    observerOn: PostThreadExecutor,
    private val view: DietPlansView,
    private var dietPlansRepository: DietPlansRepository
) : BasePresenter(subscriberOn, observerOn) {

    fun findAllDiets() {
        execute(dietPlansRepository.retrieveDietList()).subscribe({ item ->
            view.setDietList(item.result)
        }, { error ->
            view.displayError()
        }).addTo(compositeDisposable)
    }

}