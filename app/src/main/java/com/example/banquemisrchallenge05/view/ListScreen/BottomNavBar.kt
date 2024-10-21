package com.example.banquemisrchallenge05.view.ListScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.view.ui.navigation.Screens

@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomNavBar(navController: NavHostController){
    val items = listOf(Screens.NowPlaying,Screens.Popular,Screens.Upcoming)
       NavigationBar {
           items.forEach {
               NavigationBarItem(
                   selected = navController.currentBackStackEntry?.destination?.route==it.route,
                   label = { Text(text = it.title) },
                   icon = { Icon(imageVector = it.icon, contentDescription = null) },
                   onClick = {
                      navController.navigate(it.route){
                          launchSingleTop=true
                      }
                   }
               )
           }
       }
}