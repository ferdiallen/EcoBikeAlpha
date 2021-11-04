package com.tia.ecobike.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tia.ecobike.ui.theme.Greenify

@ExperimentalMaterialApi
@Composable
fun LoginDisplays() {
    val typho = MaterialTheme.typography
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4F),
            backgroundColor = Greenify,
            shape = RoundedCornerShape(bottomStart = 48.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = "Sign In",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 22.sp,
                style = typho.subtitle1, fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}