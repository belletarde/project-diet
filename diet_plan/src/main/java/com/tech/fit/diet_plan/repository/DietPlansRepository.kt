package com.tech.fit.diet_plan.repository

import com.tech.fit.diet_plan.model.DietPlanDetail
import com.tech.fit.diet_plan.model.DietPlanList
import com.tech.fit.diet_plan.model.DietPlanListApiResponse
import com.tech.fit.diet_plan.service.DietPlanApi
import io.reactivex.Single

class DietPlansRepository (private val api: DietPlanApi) {

    fun retrieveDietList(): Single<DietPlanListApiResponse> {
        return api.retrieveDietList()
    }

    fun retrieveDietDetail(id: Int): Single<DietPlanDetail> {
        return api.retrieveDietDetail(id)
    }

}