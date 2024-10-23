package com.example.banquemisrchallenge05.view.ListScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.banquemisrchallenge05.model.remote.Movie
import com.example.banquemisrchallenge05.view.DetailsScreen.releaseData
import com.example.banquemisrchallenge05.view.ui.navigation.Screens

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieItem(movie:Movie,navController: NavHostController){
    val painter= rememberAsyncImagePainter(
        model = "https://image.tmdb.org/t/p/w500"+movie.poster_path
    )
    Card(modifier =Modifier.width(200.dp).height(315.dp).padding(4.dp).clickable {
        navController.navigate("${Screens.MovieDetails.route}/${movie.id}")
    }
        , shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(12.dp)
    )  {
       Image(painter = painter,contentDescription = null, contentScale = ContentScale.Crop,
           modifier = Modifier.fillMaxWidth().height(250.dp))
        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
            Text(
                text = movie.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 2.dp)
            )
            Text(
                text = releaseData(movie.release_date), fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 2.dp)
            )
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun MovieItemPreview(){
    Column(verticalArrangement = Arrangement.Center) {
        MovieItem(
            Movie(
                123456, "the wild robot", "12-10-2024", "/wTnV3PCVW5O92JMrFvvrRcV39RU.jpg"
            ), rememberNavController()
        )
        MovieItem(
            Movie(
                123456, "the wild robot", "12-10-2024", "/wTnV3PCVW5O92JMrFvvrRcV39RU.jpg"
            ), rememberNavController()
        )
    }
}