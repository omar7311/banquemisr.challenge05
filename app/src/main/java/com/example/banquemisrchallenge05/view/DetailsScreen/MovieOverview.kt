package com.example.banquemisrchallenge05.view.DetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieOverview(overview:String){
    Card(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.dp)
        , shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(12.dp)) {
        Text(text = "Overview", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 4.dp), textAlign = TextAlign.Start)
        Text(text = overview, fontSize = 16.sp, modifier = Modifier.fillMaxWidth().wrapContentHeight()
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 8.dp))
    }
}