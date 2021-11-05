package com.tia.ecobike.navigation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tia.ecobike.ui.theme.Greenify

@ExperimentalMaterialApi
@Composable
fun LoginDisplays() {
    val dark = isSystemInDarkTheme()
    val typho = MaterialTheme.typography
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    fun isDark(): Color {
        return when (dark) {
            true -> {
                Color.White
            }
            false -> {
                Color.Black
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3F),
            backgroundColor = Greenify,
            shape = RoundedCornerShape(bottomStart = 76.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Sign In",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 22.sp,
                style = typho.subtitle1, fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Welcome !",
            modifier = Modifier.padding(start = 26.dp, top = 18.dp, bottom = 4.dp),
            color = Color.Gray,
            fontFamily = FontFamily.SansSerif, fontSize = 22.sp
        )
        Text(
            text = "Login to your account now",
            modifier = Modifier.padding(start = 26.dp),
            color = Color.Gray,
            fontFamily = FontFamily.SansSerif, fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Email",
            color = Color.Gray,
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start, modifier = Modifier.padding(start = 36.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(0.8F)
                    .height(50.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = isDark(),
                    unfocusedIndicatorColor = isDark(),
                    focusedIndicatorColor = isDark()
                ), maxLines = 1, singleLine = true
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Password",
            modifier = Modifier.padding(start = 36.dp, top = 8.dp),
            color = Color.Gray,
            fontFamily = FontFamily.SansSerif, fontSize = 16.sp, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .height(50.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val images = when (isPasswordVisible) {
                        true -> Icons.Filled.Visibility
                        false -> Icons.Filled.VisibilityOff
                    }
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = images,
                            contentDescription = "visibility password",
                            tint = isDark()
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = isDark(),
                    unfocusedIndicatorColor = isDark(),
                    focusedIndicatorColor = isDark()
                ), maxLines = 1, singleLine = true

            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Greenify),
                modifier = Modifier.fillMaxWidth(0.7F)
            ) {
                Text(
                    text = "Sign In",
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}