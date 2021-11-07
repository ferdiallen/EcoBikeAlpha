package com.tia.ecobike.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tia.ecobike.R
import com.tia.ecobike.ui.theme.Greenify
import com.tia.ecobike.ui.theme.GreyLight

@ExperimentalFoundationApi
@Composable
fun ForgotDisplay(nav: NavHostController) {
    var newpassword by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .height(55.dp)
                .padding(start = 24.dp, top = 28.dp), contentAlignment = Alignment.TopCenter
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow", modifier = Modifier.align(Center)
                )
            }
            Text(
                text = "Forgot Password",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center, fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.height(44.dp))
        Box(
            modifier = Modifier
                .size(175.dp, 175.dp)
                .clip(CircleShape)
                .background(Greenify.copy(alpha = 0.7F))
                .align(CenterHorizontally)
        ) {

        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .height(47.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(GreyLight)
                .align(CenterHorizontally), contentAlignment = Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(135.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(24.dp))
                        .weight(1F)
                        .background(Color.White), contentAlignment = Center
                ) {
                    Text(text = "Email")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .width(135.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(24.dp))
                        .weight(1F)
                        .background(Color.White), contentAlignment = Center
                ) {
                    Text(text = "Phone Number")
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.email_instructor_forgot_pass),
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 24.dp,end = 24.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Email Address",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 36.dp)
        )
    }

}
