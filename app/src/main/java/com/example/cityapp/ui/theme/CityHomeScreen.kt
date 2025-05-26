package com.example.cityapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cityapp.data.List
import com.example.cityapp.model.CityItem

@Composable
fun CityHomeScreen (
    List : List<CityItem>,
    onCoffeeClicked: () -> Unit,
    onRestaurantsClicked: () -> Unit,
    onParksClicked: () -> Unit,
    modifier: Modifier = Modifier
                    ) {
    CityList(List,
        onCoffeeClicked = onCoffeeClicked,
        onRestaurantsClicked = onRestaurantsClicked,
        onParksClicked = onParksClicked)
}

@Composable
fun CityList (List: List<CityItem>,
              onCoffeeClicked: () -> Unit,
              onRestaurantsClicked: () -> Unit,
              onParksClicked: () -> Unit) {
    LazyColumn (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        item {
            CityAppBar()
        }

        item {
            CityListItem(category = List[0],
                onButtonClicked = onCoffeeClicked)
        }

        item {
            CityListItem(category = List[1],
                onButtonClicked = onRestaurantsClicked)
        }

        item {
            CityListItem(category = List[2],
                onButtonClicked = onParksClicked)
        }
    }
}

@Composable
fun CityListItem (
    category: CityItem,
    onButtonClicked: () -> Unit
) {
    Card (
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier.fillMaxWidth(),
        onClick = onButtonClicked
    ) {
        Text(text = category.category,
            fontSize = 30.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppBar () {
    TopAppBar(
        title = {
        Text (
            "City App",
            fontWeight = FontWeight.Bold
        )
    }
    )
}