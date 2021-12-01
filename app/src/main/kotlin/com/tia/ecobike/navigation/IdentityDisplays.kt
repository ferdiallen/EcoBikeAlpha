package com.tia.ecobike.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tia.ecobike.R
import com.tia.ecobike.bottomnav.BottomBarScreenHolder
import com.tia.ecobike.darklightcontroller.IsDarkOrLight
import com.tia.ecobike.ui.theme.Greenify

@ExperimentalMaterialApi
@Composable
fun IdentityDisplayFirst(nav: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .height(55.dp)
                .padding(start = 24.dp, top = 28.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            IconButton(
                onClick = { nav.popBackStack() },
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.align(Alignment.Center),
                    tint = Color.Black
                )
            }
            Text(
                text = "Identity Confirmation",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Text(
            text = "Please complete your document",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 54.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(315.dp, 87.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(53.dp)
                        .clip(CircleShape)
                        .background(Greenify)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(33.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "National ID Card",
                        color = Color.Black,
                        fontSize = 17.sp,
                    )
                    Text(
                        text = "100+ countries supported",
                        color = Color.Black,
                        fontSize = 15.sp,
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = "forward icon",
                    tint = Greenify,
                    modifier = Modifier
                        .size(20.dp, 20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(315.dp, 87.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(53.dp)
                        .clip(CircleShape)
                        .background(Greenify)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(33.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Driver’s License",
                        color =Color.Black,
                        fontSize = 17.sp,
                    )
                    Text(
                        text = "EU, USA, Asia",
                        color = Color.Black,
                        fontSize = 15.sp,
                    )
                }
                Spacer(modifier = Modifier.width(85.dp))
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = "forward icon",
                    tint = Greenify,
                    modifier = Modifier
                        .size(20.dp, 20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(315.dp, 87.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(53.dp)
                        .clip(CircleShape)
                        .background(Greenify)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(33.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Passport",
                        color = Color.Black,
                        fontSize = 17.sp,
                    )
                    Text(
                        text = "150+ countries supported",
                        color = Color.Black,
                        fontSize = 15.sp,
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = "forward icon",
                    tint = Greenify,
                    modifier = Modifier
                        .size(20.dp, 20.dp)
                )
            }
        }

        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { nav.navigate(BottomBarScreenHolder.IdentitySecond.route) },
                modifier = Modifier
                    .size(130.dp, 40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.Bottom),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Greenify
                ),

                ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun IdentitySecondDisplay(nav: NavHostController) {
    var idNum by rememberSaveable {
        mutableStateOf("")
    }
    var idName by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .height(55.dp)
                .padding(start = 24.dp, top = 28.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            IconButton(
                onClick = { nav.popBackStack()},
                modifier = Modifier
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.align(Alignment.Center),
                    tint = Color.Black
                )
            }
            Text(
                text = stringResource(R.string.ident_config),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Text(
            text = stringResource(R.string.cpl_your_doc),
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 17.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
        )

        Text(
            text = stringResource(R.string.ins_your_id),
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 20.dp)
        )
        Box(
            Modifier
                .padding(start = 24.dp, top = 8.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .height(120.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.AddCircleOutline,
                    contentDescription = "add icon",
                    tint = Greenify,
                    modifier = Modifier
                        .weight(1F)
                        .size(36.dp)
                )
            }
        }

        Text(
            text = stringResource(R.string.id_card_num),
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 20.dp)
        )
        OutlinedTextField(
            value = idNum,
            onValueChange = {
                idNum = it
            },
            modifier = Modifier
                .padding(start = 24.dp, top = 8.dp)
                .fillMaxWidth(0.9F)
                .height(55.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                textColor = Color.Black,
            ), maxLines = 1, singleLine = true
        )

        Text(
            text = stringResource(R.string.name_acc_to_id),
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 20.dp)
        )
        OutlinedTextField(
            value = idName,
            onValueChange = {
                idName = it
            },
            modifier = Modifier
                .padding(start = 24.dp, top = 8.dp)
                .fillMaxWidth(0.9F)
                .height(55.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                textColor = Color.Black,
            ), maxLines = 1, singleLine = true
        )

        Text(
            text = stringResource(R.string.ins_photo_with_id),
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 20.dp)
        )

        Box(
            Modifier
                .padding(start = 24.dp, top = 8.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .height(120.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.AddCircleOutline,
                    contentDescription = "add icon",
                    tint = Greenify,
                    modifier = Modifier
                        .weight(1F)
                        .size(36.dp)
                )
            }
        }

        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .size(130.dp, 40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.Bottom),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Greenify
                ),

                ) {
                Text(
                    text = stringResource(R.string.submit),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
