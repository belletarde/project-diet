package belletarde.tech.fit.diet_plan.service

import belletarde.tech.fit.diet_plan.model.DietPlanDetail
import belletarde.tech.fit.diet_plan.model.DietPlanDetailApiResponse
import belletarde.tech.fit.diet_plan.model.DietPlanList
import belletarde.tech.fit.diet_plan.model.DietPlanListApiResponse
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