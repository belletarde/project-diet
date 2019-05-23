package com.tech.fit.diet_plan.service

import com.tech.fit.diet_plan.model.DietPlanDetail
import com.tech.fit.diet_plan.model.DietPlanDetailApiResponse
import com.tech.fit.diet_plan.model.DietPlanList
import com.tech.fit.diet_plan.model.DietPlanListApiResponse
import io.reactivex.Single

class DietPlanApi constructor() : BaseApi() {

    private var service: DietPlanService = build().create(DietPlanService::class.java)

    fun retrieveDietList(): Single<DietPlanListApiResponse> {
        return service.retrieveDietList()
    }

    fun retrieveDietDetail(id: Long): Single<DietPlanDetailApiResponse> {
        return service.retrieveDietDetails(id)
    }
}