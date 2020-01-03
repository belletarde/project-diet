package belletarde.tech.fit.diet_plan.repository

import belletarde.tech.fit.diet_plan.model.DietPlanDetailApiResponse
import belletarde.tech.fit.diet_plan.model.DietPlanListApiResponse
import belletarde.tech.fit.diet_plan.service.DietPlanApi
import io.reactivex.Single

class DietPlansRepository (private val api: DietPlanApi) {

    fun retrieveDietList(): Single<DietPlanListApiResponse> {
        return api.retrieveDietList()
    }

    fun retrieveDietDetail(id: Long): Single<DietPlanDetailApiResponse> {
        return api.retrieveDietDetail(id)
    }

}