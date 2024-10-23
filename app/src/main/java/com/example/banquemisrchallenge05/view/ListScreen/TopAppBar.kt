package com.example.banquemisrchallenge05.view.ListScreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.view.ui.navigation.Screens
import com.example.banquemisrchallenge05.view.ui.theme.Purple40
import com.example.banquemisrchallenge05.view.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title:String,navController: NavHostController){
   TopAppBar(modifier = Modifier.fillMaxWidth()
       .clip(RoundedCornerShape(20.dp)),
       title = {
       Text(text =title, fontSize = 22.sp, fontWeight = FontWeight.Bold,
       modifier = Modifier.fillMaxWidth().padding(end = if(title==Screens.MovieDetails.title) 32.dp else 0.dp),
           textAlign = TextAlign.Center)
   },
       colors = TopAppBarDefaults.mediumTopAppBarColors(if(isSystemInDarkTheme()) Purple40 else Purple80),
       navigationIcon = {
           if(title==Screens.MovieDetails.title) {
               IconButton(
                   onClick = {
                       navController.popBackStack()
                   },
                   modifier = Modifier.padding(start = 10.dp)
               ) {
                   Icon(
                       imageVector = Icons.Default.ArrowBack,
                       contentDescription = "Back",
                   )
               }
           }
       }

   )
}
