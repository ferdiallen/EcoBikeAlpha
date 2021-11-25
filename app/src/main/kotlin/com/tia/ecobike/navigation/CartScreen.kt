package com.tia.ecobike.navigation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tia.ecobike.R
import com.tia.ecobike.darklightcontroller.IsDarkOrLight
import com.tia.ecobike.ui.theme.Greenify
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun CartDisplayScreen(nav: NavHostController) {
    val colorstate = IsDarkOrLight.isDarkOrLight()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(19.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "arrow back in cart",
                modifier = Modifier
                    .weight(1F)
                    .size(25.dp, 24.dp)
                    .clickable { nav.popBackStack() },
                tint = colorstate
            )
            Text(
                text = "Cart", color = colorstate,
                textAlign = TextAlign.Center, fontSize = 24.sp, modifier = Modifier.weight(5F)
            )
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "menu borgir",
                modifier = Modifier.weight(
                    1F
                ), tint = colorstate
            )
        }
        Spacer(modifier = Modifier.height(52.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 18.dp)
        ) {
            items(1) {
                Surface(shape = RoundedCornerShape(12.dp), elevation = 12.dp) {
                    CartTransactionDetail(
                        transactNum = "12345678919012",
                        stationName = "Klojen,Malang",
                        subTotal = "1.300.000",
                        bikeVendor = "Xiaomi",
                        bikeType = "HIMI C16",
                        perHourPrice = "10.000", duration = "3 Hours"
                    )
                }
            }
        }
        Box(
            Modifier
                .fillMaxHeight()
                .padding(bottom = 8.dp), contentAlignment = BottomCenter
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Greenify),
                modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .height(43.dp), shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Proceed to checkout",
                    color = Color.White,
                    modifier = Modifier.weight(4F), fontSize = 12.sp, textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.weight(4F))
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = "forward icon",
                    tint = Color.White, modifier = Modifier
                        .weight(1F)
                        .size(8.57.dp, 15.dp)
                )
            }
        }
    }

}

@ExperimentalMaterialApi
@Composable
fun CartTransactionDetail(
    transactNum: String,
    stationName: String,
    subTotal: String,
    duration: String,
    bikeVendor: String,
    bikeType: String,
    perHourPrice: String
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
    var sizeForSubTotal by remember {
        mutableStateOf(1F)
    }
    var arrowRotation by remember {
        mutableStateOf(90F)
    }
    val sizeToIncrease by animateFloatAsState(targetValue = sizeForNumber)
    val sizeToIncreaseSubTotal by animateFloatAsState(targetValue = sizeForSubTotal)
    val sizeAnimateCard by animateDpAsState(targetValue = sizeOfCards)
    val colorstate = IsDarkOrLight.isDarkOrLight()
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
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(modifier = Modifier
                    .size(47.dp, 98.dp)
                    .padding(end = 12.dp),backgroundColor = Greenify) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete icon",
                        tint = Color.White,modifier = Modifier.width(24.dp).height(24.dp)
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
                            text = "No Transaksi",
                            color = colorstate,
                            modifier = Modifier
                                .weight(2F),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = transactNum,
                            color = colorstate,
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
                    Divider(color = colorstate, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Station Location",
                        color = colorstate,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            when (sizeOfCards) {
                                110.dp -> {
                                    sizeOfCards = 250.dp
                                    arrowRotation = 270F
                                }
                                250.dp -> {
                                    sizeOfCards = 110.dp
                                    arrowRotation = 90F
                                }
                            }
                        }) {
                        Icon(
                            imageVector = Icons.Filled.PinDrop,
                            contentDescription = "Locations",
                            tint = colorstate, modifier = Modifier.weight(1F)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = stationName,
                            color = colorstate,
                            fontSize = 12.sp,
                            modifier = Modifier.weight(
                                8F
                            )
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForwardIos,
                            contentDescription = "leverage the items",
                            tint = Greenify,
                            modifier = Modifier
                                .weight(
                                    1F
                                )
                                .size(6.dp, 10.dp)
                                .rotate(animateArrowRotation)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(thickness = 1.dp, color = colorstate)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            text = "Sub Total",
                            modifier = Modifier.weight(2.7F),
                            fontWeight = FontWeight.Bold,
                            color = colorstate
                        )
                        Text(
                            text = "Rp. $subTotal",
                            color = colorstate,
                            modifier = Modifier
                                .weight(sizeToIncreaseSubTotal)
                                .clickable {
                                    sizeForSubTotal = when (sizeForSubTotal) {
                                        1F -> 1.8F
                                        else -> 1F
                                    }
                                },
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis, maxLines = 1
                        )
                    }
                    Row {
                        Text(
                            text = "Duration",
                            modifier = Modifier.weight(3.5F),
                            fontWeight = FontWeight.Bold,
                            color = colorstate
                        )
                        Text(
                            text = duration,
                            color = colorstate,
                            modifier = Modifier
                                .weight(1F),
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis, maxLines = 1
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Divider(thickness = 1.dp, color = colorstate)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Card(
                            modifier = Modifier
                                .size(65.dp, 62.dp),
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = Greenify.copy(alpha = 0.35F)
                                .compositeOver(Color.White)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.protobike),
                                contentDescription = "Sepeda di cart"
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = bikeVendor,
                                fontSize = 12.sp,
                                color = colorstate,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = bikeType, fontSize = 11.sp, color = colorstate)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Rp.$perHourPrice/hour",
                                fontSize = 10.sp,
                                color = colorstate,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
