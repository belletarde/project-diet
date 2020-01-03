package belletarde.tech.fit.diet_plan.model

import com.google.gson.annotations.SerializedName

data class DietPlanList(
    @SerializedName("highlight")
    val highLight: DietHighLight,
    val collections: ArrayList<DietCollections>
)