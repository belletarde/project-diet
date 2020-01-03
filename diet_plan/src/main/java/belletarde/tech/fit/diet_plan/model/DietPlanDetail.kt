package belletarde.tech.fit.diet_plan.model

import com.google.gson.annotations.SerializedName


open class DietPlanDetail {
    val id: Long = 0
    val title: String = ""
    val text: String = ""
    @SerializedName("image_url")
    val imageUrl: String = ""
    @SerializedName("cta")
    val buttonName: String = ""
    val type: String = "low_carb"
    val amount: Int = 55
    val features: List<String>? = null

}