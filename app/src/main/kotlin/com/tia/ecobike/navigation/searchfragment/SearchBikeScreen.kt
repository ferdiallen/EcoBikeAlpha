package com.tia.ecobike.navigation.searchfragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tia.ecobike.R
import com.tia.ecobike.darklightcontroller.IsDarkOrLight
import com.tia.ecobike.ui.theme.Greenify

@Composable
fun SearchScreenBike(nav: NavHostController) {
    val focusmgr = LocalFocusManager.current
    var search by remember {
        mutableStateOf("")
    }
    DisposableEffect(key1 = Unit) {
        onDispose { }
    }
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIos,
                contentDescription = "back search menu",
                tint = Color.Black, modifier = Modifier
                    .clickable { nav.popBackStack() }
                    .weight(1F)
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .clip(RoundedCornerShape(12.dp))
                    .weight(4F),
                color = Greenify,
                elevation = 14.dp
            ) {
                TextField(
                    value = search,
                    onValueChange = {
                        search = it
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    maxLines = 1,
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            "search field",
                            tint = Greenify
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Greenify,
                        backgroundColor = Color.White
                    ), label = {
                        Text(text = "Search bike", color = Greenify)
                    }, keyboardActions = KeyboardActions(onDone = {
                        focusmgr.clearFocus()
                    })
                )
            }
            BadgedBox(
                badge = { Badge { Text(text = "10", color = Color.White) } },
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Badge Notif",
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
        }
        Spacer(modifier = Modifier.height(49.dp))
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 32.dp)
        ) {
            Text(
                text = "Latest search",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(4) {
                    LatestSearchLists(name = "Something something...")
                }
            }
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = "Near Me",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(2) {
                    Surface(shape = RoundedCornerShape(8.dp)) {
                        NearMeList(
                            name = "Someplace",
                            "2,4",
                            "4.0",
                            painterResource(id = R.drawable.dinoyoedit),
                            10
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LatestSearchLists(name: String) {
    Row(Modifier.fillMaxWidth()) {
        Icon(
            imageVector = Icons.Filled.History,
            contentDescription = "clock history",
            tint = Color.Black, modifier = Modifier.weight(1F)
        )
        Spacer(modifier = Modifier.width(29.dp))
        Text(
            text = name,
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.weight(
                11F
            )
        )
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "delete history",
            tint = Color.Black, modifier = Modifier.weight(1F)
        )
        Spacer(modifier = Modifier.width(22.dp))
    }
}

@Composable
fun NearMeList(
    name: String,
    distance: String,
    rating: String,
    images: Painter,
    availability: Int
) {
    Card(modifier = Modifier.size(317.dp, 116.dp)) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(start = 14.dp, top = 4.dp)
        ) {
            Column {
                Text(text = name, color = Color.Black)
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = images,
                    contentDescription = "icons for near me",
                    modifier = Modifier
                        .size(74.dp, 74.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }
            Column(Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Sunan Kalijaga Street\n" +
                            "Dinoyo, Malang City, East Java",
                    color = Color.Black,
                    fontSize = 12.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "$distance km ", fontSize = 10.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.stars),
                        contentDescription = "A stars",
                        modifier = Modifier.size(10.dp, 10.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = rating, fontSize = 10.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp, 16.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(Greenify)
                            .weight(1F)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.greenbike),
                            contentDescription = "Sepeda hijau"
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$availability Available",
                        color = Color.Black,
                        fontSize = 10.sp, modifier = Modifier.weight(9F)
                    )
                    Box(
                        modifier = Modifier
                            .size(72.dp, 17.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Greenify)
                            .weight(4F),contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Visit",
                            color = Color.White,
                            fontSize = 12.sp, textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}
