package com.tia.ecobike.navigation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.tia.ecobike.R
import com.tia.ecobike.bottomnav.BottomBarScreenHolder
import com.tia.ecobike.darklightcontroller.IsDarkOrLight
import com.tia.ecobike.navigators.NavigatorQueue
import com.tia.ecobike.objtest.LinksTest
import com.tia.ecobike.ui.theme.Greenify


@ExperimentalCoilApi
@Composable
fun ProfileScreens(nav: NavHostController, mainNav: NavHostController) {
    var username by remember { mutableStateOf("") }
    var emailAddress by remember {
        mutableStateOf("")
    }
    var isRotated by remember {
        mutableStateOf(false)
    }
    val animateRotation by animateFloatAsState(targetValue = if (isRotated) 90F else -90F)
    var currentLanguageTabSize by remember {
        mutableStateOf(34.9)
    }
    val animateLanguageTabSize by animateDpAsState(targetValue = currentLanguageTabSize.dp)
    currentLanguageTabSize = if (isRotated) 120.0 else 34.9
    var selected by remember {
        mutableStateOf(false)
    }
    selected = true
    //prototype only
    username = "Naruto"
    emailAddress = "konohanoshinobinaruto@gmail.com"
    val imgpainter =
        rememberImagePainter(LinksTest.mainProfileImages,
            builder = {
                placeholder(R.drawable.empty)
                this.transformations(CircleCropTransformation())
            }
        )
    Box(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .clickable(enabled = false, onClick = {}),
            backgroundColor = Greenify, shape = RoundedCornerShape(
                bottomStart = 64.dp, bottomEnd = 64.dp
            )
        ) {}
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(47.dp)
                    .padding(start = 2.dp, end = 2.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                IconButton(
                    onClick = {mainNav.popBackStack()},
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Back profile",
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(R.string.header_profile),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(7F), textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1F))
            }
            Spacer(modifier = Modifier.height(14.dp))
            Column(Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
                Box(Modifier.fillMaxSize()) {
                    Card(
                        modifier = Modifier
                            .fillMaxHeight(0.92F)
                            .fillMaxWidth(0.9F)
                            .padding(top = 32.dp)
                            .align(Alignment.Center)
                        ,
                        shape = RoundedCornerShape(12.dp),
                        elevation = 12.dp, backgroundColor = Color.White
                    ) {
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(top = 64.dp)
                        ) {
                            Text(
                                text = username,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold, color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = emailAddress,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp, color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(22.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .clickable {
                                        mainNav.navigate(BottomBarScreenHolder.EditProfile.route)
                                    }
                            ) {
                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = Greenify
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Edit,
                                        contentDescription = "For Edit profile",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = stringResource(R.string.ed_pr),
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                            Row(
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .clickable { }) {
                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = Greenify
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Password,
                                        contentDescription = "For change password",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = stringResource(R.string.pw_ch),
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                            Row(
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .clickable {
                                        mainNav.navigate(BottomBarScreenHolder.IdentityFirst.route)
                                    }) {
                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = Greenify
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Person,
                                        contentDescription = "For Identity Confirmation",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = stringResource(R.string.idconf),
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                            Row(
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .clickable {
                                        mainNav.navigate(BottomBarScreenHolder.History.route)
                                    }) {
                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = Greenify
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.History,
                                        contentDescription = "For history",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = stringResource(R.string.history),
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(24.dp))
                            Divider(
                                color = Color.Gray,
                                modifier = Modifier
                                    .fillMaxWidth(0.9F)
                                    .align(CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(animateLanguageTabSize), color = Color.Transparent
                            ) {
                                Column(Modifier.fillMaxSize()) {
                                    Row(
                                        modifier = Modifier
                                            .padding(start = 24.dp)
                                            .fillMaxWidth()
                                            .clickable {
                                                isRotated = !isRotated
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Surface(
                                            modifier = Modifier.size(35.dp),
                                            shape = CircleShape,
                                            color = Greenify
                                        ) {
                                            Icon(
                                                imageVector = Icons.Filled.Language,
                                                contentDescription = "For Languages",
                                                modifier = Modifier.scale(0.6F),
                                                tint = Color.White
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(24.dp))
                                        Text(
                                            text = stringResource(R.string.languages),
                                            color = Color.Black,
                                            fontSize = 18.sp, modifier = Modifier.weight(6F)
                                        )
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBackIosNew,
                                            contentDescription = "select language",
                                            tint = Greenify,
                                            modifier = Modifier
                                                .rotate(animateRotation)
                                                .weight(2F)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(12.dp))
                                    if (isRotated) {
                                        Row(
                                            Modifier
                                                .fillMaxWidth()
                                                .padding(start = 24.dp)
                                                .clickable {
                                                    selected = true
                                                }) {
                                            Text(
                                                text = stringResource(R.string.eng),
                                                fontSize = 17.sp,
                                                modifier = Modifier, color = Color.Black

                                            )
                                            Spacer(modifier = Modifier.width(12.dp))
                                            if (selected) {
                                                Icon(
                                                    imageVector = Icons.Filled.Done,
                                                    contentDescription = "Done", tint = Greenify
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row(
                                            Modifier
                                                .fillMaxWidth()
                                                .padding(
                                                    start = 24.dp,
                                                    bottom = 4.dp
                                                )
                                                .clickable {
                                                    selected = false
                                                }) {
                                            Text(
                                                text = stringResource(R.string.indo_language),
                                                fontSize = 17.sp,
                                                modifier = Modifier, color = Color.Black
                                            )
                                            Spacer(modifier = Modifier.width(12.dp))
                                            if (!selected) {
                                                Icon(
                                                    imageVector = Icons.Filled.Done,
                                                    contentDescription = "Done", tint = Greenify
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .clickable { }) {
                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = Greenify
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Info,
                                        contentDescription = "For Information",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = stringResource(R.string.info),
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth(0.9F)
                                    .align(CenterHorizontally),
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .clickable {
                                        nav.navigate(NavigatorQueue.Login.route) {
                                            popUpTo(NavigatorQueue.Main.route) {
                                                inclusive = true
                                            }
                                        }
                                    }) {
                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = Greenify
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Logout,
                                        contentDescription = "For Logout",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = stringResource(R.string.exit),
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                    Column(
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top
                    ) {
                        Surface(
                            modifier = Modifier
                                .size(123.dp, 123.dp)
                                .border(4.dp, shape = CircleShape, color = Color.White),
                            shape = CircleShape,
                            color = Color.Transparent
                        ) {
                            Image(
                                painter = imgpainter,
                                contentDescription = "Profile Image"
                            )
                        }
                    }

                }
            }
        }
    }
}
