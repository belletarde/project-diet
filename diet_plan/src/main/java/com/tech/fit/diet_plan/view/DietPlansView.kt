package com.tech.fit.diet_plan.view

import com.tech.fit.diet_plan.model.DietPlanList

interface DietPlansView : BaseView {
    fun setDietList(dietList:DietPlanList)
}