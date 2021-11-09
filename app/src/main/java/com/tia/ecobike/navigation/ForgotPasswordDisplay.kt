package com.tia.ecobike.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tia.ecobike.R
import com.tia.ecobike.navigators.NavigatorQueue
import com.tia.ecobike.ui.theme.Greenify
import com.tia.ecobike.ui.theme.GreyLight

@ExperimentalFoundationApi
@Composable
fun ForgotDisplay(nav: NavHostController) {
    val isSelected = BooleanArray(2)
    isSelected[0] = true
    var select1 by rememberSaveable {
        mutableStateOf(isSelected[0])
    }

    var select2 by rememberSaveable() {
        mutableStateOf(isSelected[1])
    }

    var emailaddr by rememberSaveable {
        mutableStateOf("")
    }

    val isSystemDark = isSystemInDarkTheme()
    fun isDark(): Color {
        return when (isSystemDark) {
            true -> {
                Color.White
            }
            false -> {
                Color.Black
            }
        }
    }

    fun whichSelected(data: Boolean): Color {
        return when (data) {
            true -> {
                Color.White
            }
            false -> {
                GreyLight
            }
        }
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
                onClick = { nav.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.align(Center),
                    tint = isDark()
                )
            }
            Text(
                text = "Forgot Password",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center, fontSize = 18.sp, color = isDark()
            )
        }
        Spacer(modifier = Modifier.height(44.dp))
        Box(
            modifier = Modifier
                .size(175.dp, 175.dp)
                .clip(CircleShape)
                .background(Greenify.copy(alpha = 0.8F))
                .align(CenterHorizontally), contentAlignment = Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.gembok_1),
                contentDescription = "gembok", modifier = Modifier.size(72.dp, 101.dp)
            )
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
                        .background(
                            color = animateColorAsState(targetValue = whichSelected(select1)).value
                        )
                        .clickable {
                            select1 = true
                            select2 = false
                        }, contentAlignment = Center
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
                        .background(
                            animateColorAsState(
                                targetValue = whichSelected(select2),
                                animationSpec = tween(
                                    durationMillis = 350,
                                    easing = LinearOutSlowInEasing
                                )
                            ).value
                        )
                        .clickable {
                            select2 = true
                            select1 = false
                        }, contentAlignment = Center
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        if (select1) {
            Text(
                text = "Email Address",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = emailaddr,
                onValueChange = {
                    emailaddr = it
                },
                modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .height(55.dp)
                    .align(CenterHorizontally),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = isDark(),
                    unfocusedIndicatorColor = isDark(), textColor = isDark()
                ),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        } else {
            if (emailaddr.isNotEmpty()) {
                emailaddr = ""
            }
            Text(
                text = "Phone Number",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = emailaddr,
                onValueChange = {
                    emailaddr = it
                },
                modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .height(55.dp)
                    .align(CenterHorizontally),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = isDark(),
                    unfocusedIndicatorColor = isDark(), textColor = isDark()
                ),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { nav.navigate(NavigatorQueue.ForgotPhase2.route) }, modifier = Modifier
                    .fillMaxWidth(0.4F)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Bottom), colors = ButtonDefaults.buttonColors(backgroundColor = Greenify)
            ) {
                Text(text = "Send", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ForgotDisplayPhase2(nav: NavHostController) {
    val cumulativeCodes = mutableListOf("", "", "", "")
    var verifcodes by rememberSaveable {
        mutableStateOf(cumulativeCodes[0])
    }
    var verifcodes2 by rememberSaveable {
        mutableStateOf(cumulativeCodes[1])
    }
    var verifcodes3 by rememberSaveable {
        mutableStateOf(cumulativeCodes[2])
    }
    var verifcodes4 by rememberSaveable {
        mutableStateOf(cumulativeCodes[3])
    }
    val isSystemDark = isSystemInDarkTheme()
    fun isCompletedCode(): Boolean {
        return (verifcodes.isNotEmpty()
                && verifcodes2.isNotEmpty()
                && verifcodes3.isNotEmpty()
                && verifcodes4.isNotEmpty())
    }

    fun isDark(): Color {
        return when (isSystemDark) {
            true -> {
                Color.White
            }
            false -> {
                Color.Black
            }
        }
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
                onClick = { nav.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.align(Center),
                    tint = isDark()
                )
            }
            Text(
                text = "Verify Your Email",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center, fontSize = 18.sp, color = isDark()
            )
        }
        Spacer(modifier = Modifier.height(44.dp))
        Box(
            modifier = Modifier
                .size(175.dp, 175.dp)
                .clip(CircleShape)
                .background(Greenify.copy(alpha = 0.8F))
                .align(CenterHorizontally), contentAlignment = Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.group4),
                contentDescription = "gembok", modifier = Modifier.size(72.dp, 101.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Please Enter The 4 Digit Code Sent to\n" +
                    "xxxxxxxxxxx@gmail.com",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )
        Spacer(modifier = Modifier.height(42.dp))
        Row(
            Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = verifcodes,
                onValueChange = {
                    if (it.length <= 1)
                        verifcodes = it
                },
                modifier = Modifier
                    .width(65.dp)
                    .padding(end = 12.dp),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = isDark(),
                    unfocusedIndicatorColor = Greenify,
                    focusedIndicatorColor = Greenify,
                    backgroundColor = Color.Transparent
                ), textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            )
            TextField(
                value = verifcodes2, onValueChange = {
                    if (it.length <= 1)
                        verifcodes2 = it
                }, modifier = Modifier
                    .width(65.dp)
                    .padding(end = 12.dp),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = isDark(),
                    unfocusedIndicatorColor = Greenify,
                    focusedIndicatorColor = Greenify,
                    backgroundColor = Color.Transparent
                )
            )
            TextField(
                value = verifcodes3, onValueChange = {
                    if (it.length <= 1)
                        verifcodes3 = it
                }, modifier = Modifier
                    .width(65.dp)
                    .padding(end = 12.dp),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = isDark(),
                    unfocusedIndicatorColor = Greenify,
                    focusedIndicatorColor = Greenify,
                    backgroundColor = Color.Transparent
                )
            )
            TextField(
                value = verifcodes4, onValueChange = {
                    if (it.length <= 1)
                        verifcodes4 = it
                }, modifier = Modifier
                    .width(65.dp)
                    .padding(end = 12.dp),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = isDark(),
                    unfocusedIndicatorColor = Greenify,
                    focusedIndicatorColor = Greenify,
                    backgroundColor = Color.Transparent
                )
            )
        }
        Spacer(modifier = Modifier.height(98.dp))
        Text(text = "Resend Code", modifier = Modifier.align(CenterHorizontally), color = Greenify)
        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { nav.navigate(NavigatorQueue.ForgotPhaseFinal.route) },
                modifier = Modifier
                    .fillMaxWidth(0.4F)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Bottom),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =
                    if (isCompletedCode()) Color.Green
                    else GreyLight
                ),
                enabled = isCompletedCode()
            ) {
                Text(text = "Verify", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ForgotDisplayFinalPhase(nav: NavHostController) {
    var passwords by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    var visibility1 by remember {
        mutableStateOf(true)
    }
    var visibility2 by remember {
        mutableStateOf(true)
    }
    val isSystemDark = isSystemInDarkTheme()
    fun isDark(): Color {
        return when (isSystemDark) {
            true -> {
                Color.White
            }
            false -> {
                Color.Black
            }
        }
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
                onClick = { nav.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.align(Center),
                    tint = isDark()
                )
            }
            Text(
                text = "Create New Password",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center, fontSize = 18.sp, color = isDark()
            )
        }
        Spacer(modifier = Modifier.height(44.dp))
        Box(
            modifier = Modifier
                .size(175.dp, 175.dp)
                .clip(CircleShape)
                .background(Greenify.copy(alpha = 0.8F))
                .align(CenterHorizontally), contentAlignment = Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.gembok_2),
                contentDescription = "gembok", modifier = Modifier.size(72.dp, 101.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Your New Password Must Be Different\n" +
                    "from Previously Used Password",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Password",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = passwords,
            onValueChange = {
                passwords = it
            },
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .height(55.dp)
                .align(CenterHorizontally),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = isDark(),
                unfocusedIndicatorColor = isDark(), textColor = isDark()
            ),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Icon(
                    imageVector = if (visibility1) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff,
                    contentDescription = "pw icon",
                    modifier = Modifier.clickable {
                        visibility1 = !visibility1
                    }, tint = isDark()
                )
            },
            visualTransformation = if (visibility1) PasswordVisualTransformation() else VisualTransformation.None
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Confirm Password",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .height(55.dp)
                .align(CenterHorizontally),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = isDark(),
                unfocusedIndicatorColor = isDark(), textColor = isDark()
            ),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Icon(
                    imageVector = if (visibility2) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff,
                    contentDescription = "pw confirm icon", modifier = Modifier.clickable {
                        visibility2 = !visibility2
                    }, tint = isDark()
                )
            },
            visualTransformation = if (visibility2) PasswordVisualTransformation() else VisualTransformation.None
        )
        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { nav.navigate(NavigatorQueue.Login.route){
                    popUpTo(NavigatorQueue.Login.route){
                        inclusive = true
                    }
                } }, modifier = Modifier
                    .fillMaxWidth(0.4F)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Bottom), colors = ButtonDefaults.buttonColors(backgroundColor = Greenify)
            ) {
                Text(text = "Reset Password", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }
}
