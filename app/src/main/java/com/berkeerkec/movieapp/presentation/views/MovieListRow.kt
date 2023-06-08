package com.berkeerkec.movieapp.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import com.berkeerkec.movieapp.domain.model.Movie

@Composable
fun MovieListRow(
    movie : Movie,
    onItemClick : (Movie) -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClick(movie)
        }
        .padding(6.dp),
    horizontalArrangement = Arrangement.SpaceBetween) {
        
        Image(painter = rememberAsyncImagePainter(model = movie.Poster), contentDescription = movie.Title,
        modifier = Modifier
            .padding(12.dp)
            .size(200.dp, 200.dp)
            .clip(RectangleShape))

        Column(
            modifier = Modifier.align(CenterVertically), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = movie.Title,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            textAlign = TextAlign.Center)

            Text(text = movie.Year,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Center)
        }
    }
}