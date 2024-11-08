package com.example.hits.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hits.R
import com.example.hits.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, mainScreenViewModel: MainScreenViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Today's Hits",
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
            )
        }) {
        it.calculateTopPadding()
        MainContent(navController =navController)
    }

}
@Composable
fun MainContent(
    hits: List<String> = listOf("Leggins", "T-shirts", "Sweaters", "Jeans"),
    navController: NavController
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(top = 90.dp)
            .padding(16.dp)
    ) {
        Portforlio(hits, onitemClick = {
            navController.navigate(route =Screens.DetailScreen.name + "/$it")
        })
    }
}

@Composable
fun Portforlio(data: List<String>, onitemClick: (String) -> Unit) {
    LazyColumn {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillParentMaxWidth()
                    .clickable {
                        it.let(onitemClick)
                    }
                ,
                shape = RectangleShape,


                ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                ) {
                    CreateProjectPic(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(3.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(it, fontWeight = FontWeight.Bold)
                        Text("great project")
                        Text("great project")
                        Text("great project")
                    }

                }


            }
        }
    }
}

@Composable
fun CreateProjectPic(modifier: Modifier) {
    Surface(
        modifier = modifier.clickable {

        },
        shape = CircleShape,

        border = BorderStroke(0.5.dp, color = Color.White),
        tonalElevation = 4.dp,

        ) {


        Image(
            painterResource(id = R.drawable.baseline_downloading_24),
            contentDescription = null,
            Modifier.fillMaxWidth()
        )
    }
}

