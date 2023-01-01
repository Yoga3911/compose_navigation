package com.example.coba2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)

@Composable
fun Counter(navController: NavController) {
    val count = remember {
        mutableStateOf("H")
    }

    val items = remember {
        mutableStateOf(
            listOf<User>(
                User("Ekoqwewqewqewqe", "21"),
                User("Pro", "22"),
                User("Mamat", "23")
            )
        )
    }
    Scaffold(
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = {
                    navController.navigate(Screen.SecondaryScreen.route)
                }, backgroundColor = Color.Blue) {
                    Icon(
                        Icons.Rounded.Clear,
                        contentDescription = "min",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                FloatingActionButton(onClick = {
                    items.value += User("Ekoqwewqewqewqe", "21")
                    println("Masuk Sini")
                }, backgroundColor = Color.Blue) {
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = "add",
                        tint = Color.White
                    )
                }
            }
        },
        content = {
            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 100.dp),
                content = {
                    items(items.value) {
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color.Green),
                            content = {
                                Column(horizontalAlignment = Alignment.Start) {
                                    Text(
                                        text = it.name,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(text = it.age)
                                }
                            }
                        )
                    }
                }
            )
        }
    )
}