package com.tia.ecobike.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tia.ecobike.ui.theme.Greenify
import com.tia.ecobike.ui.theme.GreyLight

@ExperimentalFoundationApi
@Composable
fun ForgotDisplay(nav: NavHostController) {
    var newpassword by rememberSaveable {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val reloc = BringIntoViewRequester()
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
                    contentDescription = "Back Arrow"
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
                .width(315.dp)
                .height(47.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(GreyLight)
                .align(CenterHorizontally)
        ) {

        }
    }

}
