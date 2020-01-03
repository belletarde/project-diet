package belletarde.tech.fit.diet_plan.view

import belletarde.tech.fit.diet_plan.model.DietPlanList

interface DietPlansView : BaseView {
    fun setDietList(dietList: DietPlanList)
}