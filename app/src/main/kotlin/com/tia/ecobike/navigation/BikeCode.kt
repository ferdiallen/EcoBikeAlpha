package com.tia.ecobike.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tia.ecobike.ui.theme.Greenify

@ExperimentalMaterialApi
@Composable
fun BikeCode() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .height(55.dp)
                .padding(start = 24.dp, top = 28.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.align(Alignment.Center),
                    tint = Color.Black
                )
            }
            Text(
                text = "Bike Code",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(39.dp))
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .background(Greenify)
            .size(241.dp, 183.dp)
        )
        Spacer(modifier = Modifier.height(38.dp))
        Text(
            text = "CODE",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "used to pick up the bike",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(47.dp))
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .border(BorderStroke(1.dp, Color.Gray))
            .size(274.dp, 92.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row {
                Spacer(modifier = Modifier.width(20.dp))
                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .size(51.dp, 47.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "1",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .size(51.dp, 47.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "1",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .size(51.dp, 47.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "1",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .size(51.dp, 47.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "1",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
            }

        }

        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {  },

                modifier = Modifier
                    .size(130.dp, 40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.Bottom),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Greenify
                ),

                ) {
                Text(text = "Done",
                    color = Color.White,
                    textAlign = TextAlign.Center)
            }
        }

    }
}