package com.example.banquemisrchallenge05.view.DetailsScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisrchallenge05.model.remote.genre
import com.example.banquemisrchallenge05.view.ui.theme.Purple40
import com.example.banquemisrchallenge05.view.ui.theme.Purple80
import java.time.Month

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieInfo(title:String,releaseDate:String,runtime:Int,genres:List<genre>){
    Card(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 8.dp)
        , shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(12.dp)) {
        Text(text =title, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(top=8.dp),
            fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = releaseData(releaseDate), fontSize = 16.sp, modifier = Modifier.padding(start = 12.dp) )
            Text(text = runTime(runtime), fontSize = 16.sp, modifier = Modifier.padding(end = 12.dp) )
        }
        Spacer(Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 4.dp), horizontalArrangement = Arrangement.Center
        ) {
            items(genres) { item ->
                // Customize each item in the LazyRow
                Box(modifier = Modifier.fillMaxWidth().padding(horizontal =8.dp).clip(
                    RoundedCornerShape(12.dp)).background(if(isSystemInDarkTheme()) Purple40 else Purple80)){
                Text(text = item.name , fontSize = 16.sp , modifier = Modifier.padding(horizontal = 8.dp))
            }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun releaseData(date:String):String{
    val dateList=date.split("-")
    return "${dateList[2]} ${Month.of(dateList[1].toInt()).name.lowercase().capitalize()}, ${dateList[0]}"
}
fun runTime(runtime: Int) : String {
    val hour=runtime/60
    val min=runtime%60
    return "${hour}h  ${min}m"
}