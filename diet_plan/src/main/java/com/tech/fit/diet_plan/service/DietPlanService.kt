package com.tech.fit.diet_plan.service

import com.tech.fit.diet_plan.model.DietPlanDetail
import com.tech.fit.diet_plan.model.DietPlanDetailApiResponse
import com.tech.fit.diet_plan.model.DietPlanList
import com.tech.fit.diet_plan.model.DietPlanListApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DietPlanService {

    @GET("diets")
    fun retrieveDietList(): Single<DietPlanListApiResponse>


    @GET("diets/{id}")
    fun retrieveDietDetails(@Path("id") dietId: Long?): Single<DietPlanDetailApiResponse>
}