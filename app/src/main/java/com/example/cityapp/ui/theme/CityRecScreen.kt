package com.example.cityapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cityapp.data.List
import com.example.cityapp.model.CityItem
import com.example.cityapp.model.Routes

@Composable
fun CityRecScreen(List: List<CityItem>, navController: NavHostController) {
    RecList(List,
        navController = navController)
}

@Composable
fun RecList (List: List<CityItem>,
             navController: NavHostController) {
    LazyColumn (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        item {
            CityAppBar()
        }

        items(List.size) { index ->
            CityListItem(
                category = List[index],
                onButtonClicked = { navController.navigate(Routes.Recommendations.createRoute(List[index].category)) }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDescriptionScreen(cityItem: String?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        CityAppBar()
        Spacer(modifier = Modifier.height(20.dp))
        Text("$cityItem")
    }
}
