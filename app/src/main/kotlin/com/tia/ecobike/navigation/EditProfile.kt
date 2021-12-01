package com.tia.ecobike.navigation

import android.app.DatePickerDialog
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.tia.ecobike.darklightcontroller.IsDarkOrLight
import com.tia.ecobike.objtest.LinksTest
import com.tia.ecobike.ui.theme.Greenify
import java.util.*

@ExperimentalMaterialApi
@Composable
fun EditDisplay(nav:NavHostController) {
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var phoneNum by rememberSaveable {
        mutableStateOf("")
    }
    val imagePainter =
        rememberImagePainter(data = LinksTest.editProfileImages,
            builder = {
                transformations(CircleCropTransformation())
            }
        )
    var resultOfDatePicker by remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    val c = Calendar.getInstance()
    val years = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val days = c.get(Calendar.DAY_OF_MONTH)
    val context = LocalContext.current
    val datePickerDialog = DatePickerDialog(context, { datePick, year, mon, day ->
        val months = mon + 1
        resultOfDatePicker = "$day - $months - $year"
    }, years, month, days)
    Column(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        }) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.95F)
                .height(64.dp)
                .padding(start = 24.dp, top = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(modifier = Modifier.weight(1F),
                onClick = { nav.popBackStack()}
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back Arrow",
                    tint = Color.Black
                )
            }
            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black, modifier = Modifier.weight(7F)
            )

            Surface(
                modifier = Modifier
                    .size(35.dp), shape = CircleShape, color = Greenify
            ) {
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Profile",
                        tint = Color.White
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.35F)
                .height(170.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Card(
                backgroundColor = Color.White,
                elevation = 10.dp,
                shape = CircleShape,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(125.dp)
            ) { Image(painter = imagePainter, contentDescription = "Profile Images") }
            Card(
                backgroundColor = Color.White,
                elevation = 10.dp,
                shape = CircleShape,
                modifier = Modifier
                    .padding(start = 85.dp, top = 80.dp)
                    .align(Alignment.Center)
                    .size(35.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable { },
                    tint = Greenify
                )
            }
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Your Name",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
        )
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .padding(start = 24.dp)
                .fillMaxWidth(0.9F)
                .height(55.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Greenify,
                textColor = Color.Black,
            ), maxLines = 1, singleLine = true
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Email",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
        )
        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .padding(start = 24.dp)
                .fillMaxWidth(0.9F)
                .height(55.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Greenify,
                textColor = Color.Black,
            ), maxLines = 1, singleLine = true
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Telephone Number",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
        )
        TextField(
            value = phoneNum,
            onValueChange = {
                phoneNum = it
            },
            modifier = Modifier
                .padding(start = 24.dp)
                .fillMaxWidth(0.9F)
                .height(55.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Greenify,
                textColor = Color.Black,
            ), maxLines = 1, singleLine = true
        )
        Spacer(modifier = Modifier.height(14.dp))
        /* DATE PICKER */
        Text(
            text = "Your Birthday",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
        )
        CompositionLocalProvider(LocalTextInputService provides null) {
            OutlinedTextField(
                value = resultOfDatePicker,
                onValueChange = {
                    resultOfDatePicker = it
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(start = 24.dp, top = 15.dp)
                    .onFocusChanged { focusState ->
                        if (focusState.hasFocus) {
                            datePickerDialog.show()
                            focusManager.clearFocus()
                        }
                    }
                    .fillMaxWidth(0.9F)
                    .height(55.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Greenify,
                    textColor = Color.Black,
                ), maxLines = 1, singleLine = true
            )
        }
        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 38.dp),
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
                    text = "Verify",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

