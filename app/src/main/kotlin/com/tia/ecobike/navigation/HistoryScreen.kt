package com.tia.ecobike.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.History
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tia.ecobike.R
import com.tia.ecobike.ui.theme.Greenify
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun HistoryDisplay(nav: NavHostController) {
    val isSelected = BooleanArray(2)
    isSelected[0] = true
    var select1 by rememberSaveable {
        mutableStateOf(isSelected[0])
    }

    var select2 by rememberSaveable {
        mutableStateOf(isSelected[1])
    }

    fun whichSelected(data: Boolean): Color {
        return when (data) {
            true -> {
                Color.White
            }
            false -> {
                Color.LightGray
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
            shape = RoundedCornerShape(bottomStart = 64.dp, bottomEnd = 64.dp)
        ) {
            Column(Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.95F)
                        .height(65.dp)
                        .padding(start = 24.dp, top = 4.dp, bottom = 4.dp),
                    verticalAlignment = CenterVertically
                ) {
                    IconButton(
                        onClick = { nav.popBackStack() },
                        modifier = Modifier.weight(1F)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = "Back Arrow",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.history),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color.White, modifier = Modifier.weight(7F)
                    )
                    Surface(
                        modifier = Modifier
                            .size(35.dp),shape = CircleShape, color = Color.White
                    ) {
                        Row(
                            Modifier
                                .fillMaxSize(),
                            verticalAlignment = CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.History,
                                contentDescription = stringResource(id = R.string.history),
                                tint = Greenify, modifier = Modifier.align(CenterVertically)
                            )
                        }
                    }
                }
                Text(
                    text = "Hello, Andre",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, top = 20.dp)
                )
                Text(
                    text = stringResource(R.string.history_greet),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, bottom = 20.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6F)
                        .height(47.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color.LightGray)
                        .align(Alignment.CenterHorizontally), contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(70.dp)
                                .fillMaxSize()
                                .clip(RoundedCornerShape(24.dp))
                                .weight(1F)
                                .background(
                                    color = animateColorAsState(
                                        targetValue = whichSelected(select1)
                                    ).value
                                )
                                .clickable {
                                    select1 = true
                                    select2 = false
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(R.string.process), color = Color.Black)
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Box(
                            modifier = Modifier
                                .width(70.dp)
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
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(R.string.complete), color = Color.Black)
                        }
                    }
                }
            }
        }
        if (select1) {
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(bottom = 12.dp)
            ) {
                items(1) {
                    Surface(shape = RoundedCornerShape(12.dp), elevation = 12.dp) {
                        TransactionDetail(
                            transactNum = "12345678919012",
                            stationName = "Stasiun Kota Baru",
                            stationLoc = "Klojen,Malang",
                            date = "20-05-2021 ",
                            rentDate = "Thursday, 20-05-2021",
                            rentTime = "09.35",
                            returnDate = "Thursday, 20-05-2021 ",
                            returnTime = "12.35"
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TransactionDetail(
    transactNum: String,
    stationLoc: String,
    stationName: String,
    date: String,
    rentDate: String,
    rentTime: String,
    returnDate: String,
    returnTime: String,
) {
    val swipableState = rememberSwipeableState(initialValue = 0)
    val sqpx = (-70).dp
    val sizePX = with(LocalDensity.current) {
        sqpx.toPx()
    }
    val anchor = mapOf(0f to 0, sizePX to 1)

    var sizeForNumber by remember {
        mutableStateOf(1F)
    }
    var sizeOfCards by remember {
        mutableStateOf(110.dp)
    }
    var arrowRotation by remember {
        mutableStateOf(90F)
    }
    val sizeToIncrease by animateFloatAsState(targetValue = sizeForNumber)
    val sizeAnimateCard by animateDpAsState(targetValue = sizeOfCards)
    val animateArrowRotation by animateFloatAsState(targetValue = arrowRotation)
    Column(
        modifier = Modifier
            .size(325.dp, sizeAnimateCard)
            .swipeable(state = swipableState, anchors = anchor, thresholds = { _, _ ->
                FractionalThreshold(0.3F)
            }, orientation = Orientation.Horizontal),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(47.dp, 98.dp)
                        .padding(end = 12.dp), backgroundColor = Greenify
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete icon",
                        tint = Color.White, modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                }
            }
            Card(modifier = Modifier
                .fillMaxSize()
                .offset {
                    IntOffset(
                        swipableState.offset.value.roundToInt(), 0
                    )
                }) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    Row(Modifier.fillMaxWidth()) {
                        Text(
                            text = stringResource(R.string.no_transact),
                            color = Color.Black,
                            modifier = Modifier
                                .weight(2F),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = transactNum,
                            color = Color.Black,
                            modifier = Modifier
                                .weight(sizeToIncrease)
                                .clickable {
                                    sizeForNumber = when (sizeForNumber) {
                                        1F -> {
                                            1.7F
                                        }
                                        else -> {
                                            1F
                                        }
                                    }
                                },
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(color = Color.Black, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Card(
                            modifier = Modifier
                                .size(65.dp, 62.dp),
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = Greenify.copy(alpha = 0.35F)
                                .compositeOver(Color.White)
                        ) {

                            /* IMAGE */

                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = stationName,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                verticalAlignment = CenterVertically,
                                modifier = Modifier.clickable {
                                    when (sizeOfCards) {
                                        110.dp -> {
                                            sizeOfCards = 200.dp
                                            arrowRotation = 270F
                                        }
                                        200.dp -> {
                                            sizeOfCards = 110.dp
                                            arrowRotation = 90F
                                        }
                                    }
                                }) {
                                Text(
                                    text = stationLoc,
                                    color = Color.Black,
                                    fontSize = 8.sp,
                                    modifier = Modifier.weight(
                                        8F
                                    )
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowForwardIos,
                                    contentDescription = "leverage the items",
                                    tint = Greenify,
                                    modifier = Modifier
                                        .weight(1F)
                                        .size(6.dp, 10.dp)
                                        .rotate(animateArrowRotation)
                                )
                            }
//
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(thickness = 1.dp, color = Color.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.detail),
                        modifier = Modifier.weight(2.7F),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Row {
                        Text(
                            text = stringResource(R.string.rent_time),
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(39.dp))
                        Text(
                            text = ":$rentDate ($rentTime)",
                            fontSize = 10.sp,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis, maxLines = 1
                        )
                    }
                    Row {
                        Text(
                            text = stringResource(R.string.return_time),
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        Text(
                            text = ":$returnDate ($returnTime)",
                            fontSize = 10.sp,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis, maxLines = 1
                        )
                    }
                }
            }
        }
    }
}
