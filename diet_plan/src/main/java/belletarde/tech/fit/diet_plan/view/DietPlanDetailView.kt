package belletarde.tech.fit.diet_plan.view

import belletarde.tech.fit.diet_plan.model.DietPlanDetail

interface DietPlanDetailView : BaseView {
    fun setDietDetail(dietDetail: DietPlanDetail)
}