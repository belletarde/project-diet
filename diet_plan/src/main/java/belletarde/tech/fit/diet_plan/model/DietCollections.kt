package belletarde.tech.fit.diet_plan.model

//{
//    "highlight": {
//    "id": 1,
//    "label": "Dieta Indicada",
//    "title": "Low Carb Iniciante",
//    "text": "Emagreça de forma rápida e duradoura, desintoxicando seu organismo e focando em comida de verdade!",
//    "cta": "Saiba Mais",
//    "image_url": "http://lorempixel.com/400/200/food/"
//},
//    "collections": [
//    {
//        "id": 1,
//        "title": "Planos de Dieta Premium",
//        "premium": true,
//        "diets": [
//        {
//            "id": 2,
//            "title": "Low Carb Intermediário",
//            "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit etiam odio erat egestas ullamcorper urna a.",
//            "image_url": "http://lorempixel.com/400/200/food/"
//        }
//        ]
//    }
//    ]
//}

data class DietCollections(
    val id: String = "",
    val title: String = "",
    val premium: Boolean = true,
    val diets: ArrayList<DietPlanDetail>)