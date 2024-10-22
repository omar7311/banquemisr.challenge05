package com.example.banquemisrchallenge05.view.DetailsScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisrchallenge05.model.remote.genre

@Composable
fun MovieInfo(title:String,releaseDate:String,runtime:Int,genres:List<genre>){
    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
        Text(text =title, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text =releaseDate, fontSize = 16.sp, modifier = Modifier.padding(start = 12.dp) )
            Text(text ="$runtime m", fontSize = 16.sp, modifier = Modifier.padding(end = 12.dp) )
        }
        Spacer(Modifier.height(12.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            items(genres) { item ->
                // Customize each item in the LazyRow
                Spacer(Modifier.width(16.dp))
                Text(text = item.name , fontSize = 16.sp )
            }
        }
    }
}