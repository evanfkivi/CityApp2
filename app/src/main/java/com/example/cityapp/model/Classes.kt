package com.example.cityapp.model

data class CityItem(
    val category: String,
    val type: String
)

data class CityUiState(
    val List: List<CityItem> = emptyList(),
    val currentCategory: CityItem = CityItem("", "")
)

//sealed class Routes {
//    abstract val id: String
//    data class CategoryScreen(
//        val specialParam: String
//    ): Routes() {
//        override val id: String = "categories"
//    }
//    data object RecScreen : Routes() {
//        override val id: String = "recs"
//    }
//    )
//}

sealed class Routes(val route: String) {
    object Start: Routes("start")
    object Coffee: Routes("coffee")
    object Restaurants: Routes("restaurants")
    object Parks: Routes("parks")
    object Recommendations: Routes("recommendations/{cityItem}") {
        fun createRoute(cityItem: String) = "recommendations/$cityItem"
    }
}