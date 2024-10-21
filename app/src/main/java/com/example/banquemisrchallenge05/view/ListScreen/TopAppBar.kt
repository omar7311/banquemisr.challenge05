package com.example.banquemisrchallenge05.view.ListScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title:String){
   TopAppBar(modifier = Modifier.fillMaxWidth()
       .clip(RoundedCornerShape(20.dp)),
       title = {
       Text(text =title, fontSize = 22.sp, fontWeight = FontWeight.Bold,
       modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
   } )
}
@Preview(showSystemUi = true)
@Composable
fun TopAppBarPreview(){
    TopBar("Now Playing")
}