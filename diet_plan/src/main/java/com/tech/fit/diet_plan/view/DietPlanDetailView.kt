package com.tech.fit.diet_plan.view

import com.tech.fit.diet_plan.model.DietPlanDetail

interface DietPlanDetailView : BaseView {
    fun setDietDetail(dietDetail: DietPlanDetail)
}