package com.tia.ecobike.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tia.ecobike.R
import com.tia.ecobike.navigators.NavigatorQueue
import com.tia.ecobike.ui.theme.Greenify
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun LoginDisplays(navcon: NavHostController) {
    val dark = isSystemInDarkTheme()
    val typho = MaterialTheme.typography
    val bringint = BringIntoViewRequester()
    val scope = rememberCoroutineScope()
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(true)
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
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3F)
                .clickable(enabled = false, onClick = {}),
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
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
                    .height(50.dp)
                    .bringIntoViewRequester(bringint)
                    .onFocusEvent {
                        if (it.isFocused) {
                            scope.launch {
                                bringint.bringIntoView()
                            }
                        }
                    },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
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
                ),
                maxLines = 1,
                singleLine = true,
                visualTransformation = when (isPasswordVisible) {
                    true -> {
                        PasswordVisualTransformation()
                    }
                    false -> {
                        VisualTransformation.None
                    }
                }

            )
            Text(
                text = "Forgot Password ?",
                modifier = Modifier
                    .padding(top = 4.dp)
                    .clickable {
                        navcon.navigate(NavigatorQueue.Forgot.route)
                    }, color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Greenify),
                modifier = Modifier
                    .fillMaxWidth(0.7F)
                    .clip(RoundedCornerShape(28.dp))
            ) {
                Text(
                    text = "Sign In",
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 48.dp, top = 32.dp, end = 48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(modifier = Modifier.weight(1F), color = Color.Gray, thickness = 1.dp)
            Text(
                text = " Or sign In with Google ",
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.weight(1F))
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(63.dp)
                .height(34.dp)
                .align(CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "google button", modifier = Modifier.size(20.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .align(BottomCenter)
                    .padding(bottom = 12.dp)
            ) {
                Text(
                    text = "Don't have an account ? ",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Sign up",
                    fontSize = 15.sp,
                    color = Color.Blue, modifier = Modifier.clickable {

                    }
                )

            }

        }
    }
}

