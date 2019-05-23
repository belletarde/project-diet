package com.tech.fit.diet_plan.repository

import com.tech.fit.diet_plan.model.DietPlanDetailApiResponse
import com.tech.fit.diet_plan.model.DietPlanListApiResponse
import com.tech.fit.diet_plan.service.DietPlanApi
import io.reactivex.Single

class DietPlansRepository (private val api: DietPlanApi) {

    fun retrieveDietList(): Single<DietPlanListApiResponse> {
        return api.retrieveDietList()
    }

    fun retrieveDietDetail(id: Long): Single<DietPlanDetailApiResponse> {
        return api.retrieveDietDetail(id)
    }

}