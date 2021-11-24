package com.tia.ecobike.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.tia.ecobike.darklightcontroller.IsDarkOrLight
import com.tia.ecobike.ui.theme.Greenify


@Composable
fun ProfileScreens() {
    val cs = IsDarkOrLight.isDarkOrLight()
    var username by remember { mutableStateOf("") }
    var emailAddress by remember {
        mutableStateOf("")
    }
    //prototype only
    username = "Naruto"
    emailAddress = "konohanoshinobinaruto@gmail.com"
    var imgpainter =
        rememberImagePainter("https://sportshub.cbsistatic.com/i/2021/03/18/fbe99a54-7f1a-4ca2-ba2b-9a2e04bc1461/naruto-1249229.jpg",
            builder = {
                this.transformations(CircleCropTransformation())
            }
        )
    Box(modifier = Modifier.fillMaxWidth()) {
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
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = "Back profile",
                    tint = Color.White,
                    modifier = Modifier.weight(1F)
                )
                Text(
                    text = "Profile",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(7F), textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1F))
            }
            Spacer(modifier = Modifier.height(14.dp))
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.fillMaxSize()) {
                    Card(
                        modifier = Modifier
                            .height(545.dp)
                            .fillMaxWidth(0.9F)
                            .align(Alignment.Center),
                        shape = RoundedCornerShape(12.dp),
                        elevation = 12.dp
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
                                fontWeight = FontWeight.Bold, color = cs
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
                                    .clickable { }
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
                                Text(text = "Edit Profile", color = cs, fontSize = 18.sp)
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
                                    text = "Change Password",
                                    color = cs,
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
                                        imageVector = Icons.Filled.Person,
                                        contentDescription = "For Identity Confirmation",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = "Identity Confirmation",
                                    color = cs,
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
                                        imageVector = Icons.Filled.History,
                                        contentDescription = "For history",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = "History",
                                    color = cs,
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
                            Row(
                                modifier = Modifier
                                    .padding(start = 24.dp)
                                    .fillMaxWidth()
                                    .clickable { },verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    modifier = Modifier.size(35.dp),
                                    shape = CircleShape,
                                    color = Greenify
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Language,
                                        contentDescription = "For Languages",
                                        modifier = Modifier.scale(0.6F), tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = "Languages",
                                    color = cs,
                                    fontSize = 18.sp,modifier = Modifier.weight(6F)
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowBackIosNew,
                                    contentDescription = "select language",
                                    tint = Greenify,
                                    modifier = Modifier
                                        .rotate(-90F)
                                        .weight(2F)
                                )
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
                                    text = "Information",
                                    color = cs,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = imgpainter,
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(123.dp, 123.dp)
                                .border(
                                    border = BorderStroke(4.dp, Color.White),
                                    shape = CircleShape
                                )
                        )
                    }

                }
            }
        }
    }
}
