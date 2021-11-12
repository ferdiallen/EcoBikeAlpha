package com.tia.ecobike.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tia.ecobike.ui.theme.Greenify

@Composable
fun MainDisplays() {
    val isdark = isSystemInDarkTheme()
    var search by rememberSaveable {
        mutableStateOf("")
    }
    val focusmgr = LocalFocusManager.current
    fun isDark(): Color {
        return when (isdark) {
            true -> {
                Color.White
            }
            false -> {
                Color.Black
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .clickable(enabled = false, onClick = {}),
            backgroundColor = Greenify, shape = RoundedCornerShape(
                bottomStart = 64.dp
            )
        ) {}
        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(37.dp))
            Image(
                painter = painterResource(id = com.tia.ecobike.R.drawable.mainlogo),
                modifier = Modifier
                    .width(215.dp)
                    .height(79.dp),
                contentDescription = "for main menu"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Hello,What are you looking for ?",
                color = Color.White,
                modifier = Modifier.padding(start = 24.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .align(CenterHorizontally),
                color = MaterialTheme.colors.primary,
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
                        Text(text = "Search bike")
                    }, keyboardActions = KeyboardActions(onDone = {
                        focusmgr.clearFocus()
                    })
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                ) {
                    append("Hot ")
                }
                withStyle(style = SpanStyle(Color.White, fontSize = 17.sp)) {
                    append("Deals")
                }
            }, modifier = Modifier.padding(start = 24.dp))
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(start = 24.dp, end = 12.dp)
            ) {
                items(5) {
                    Surface(
                        elevation = 14.dp, shape = RoundedCornerShape(32.dp)
                    ) {
                        RowsOfHotDeals()
                    }
                }
            }
        }
    }
}

@Composable
fun RowsOfHotDeals() {
    Card(
        modifier = Modifier
            .size(202.dp, 231.dp)
            .clickable {

            }
    ) {

    }
}