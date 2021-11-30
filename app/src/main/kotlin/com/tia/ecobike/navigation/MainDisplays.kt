package com.tia.ecobike.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.tia.ecobike.R
import com.tia.ecobike.bottomnav.BottomBarScreenHolder
import com.tia.ecobike.bottomnav.NavGraphScaffoldBottom
import com.tia.ecobike.darklightcontroller.IsDarkOrLight
import com.tia.ecobike.darklightcontroller.UiController
import com.tia.ecobike.ui.theme.Greenify
import com.tia.ecobike.ui.theme.backgroundLights


@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun MainDisplays(nav: NavHostController) {
    val navBottomHostController = rememberNavController()
    Scaffold(bottomBar = {
        BottomBar(nav = navBottomHostController)
    }) { paddingContent ->
        Box(Modifier.padding(bottom = paddingContent.calculateBottomPadding())) {
            NavGraphScaffoldBottom(nav = navBottomHostController, nav)
        }
    }
}

@Composable
fun BottomBar(nav: NavHostController) {
    val screens = listOf(
        BottomBarScreenHolder.Mains,
        BottomBarScreenHolder.Cart,
        BottomBarScreenHolder.Profile
    )
    val stackEntry by nav.currentBackStackEntryAsState()
    val current = stackEntry?.destination
    val uiControl = UiController.setUi()
    val darkThemeObserver = isSystemInDarkTheme()
    fun isDarkItemsAllowed(): Boolean {
        return when (darkThemeObserver) {
            true -> {
                false
            }
            else -> {
                true
            }
        }
    }

    when (current?.route) {
        BottomBarScreenHolder.Cart.route -> {
            uiControl.setStatusBarColor(Color.Transparent, darkIcons = isDarkItemsAllowed())
        }
        BottomBarScreenHolder.Mains.route -> uiControl.setStatusBarColor(
            Greenify,
            darkIcons = isDarkItemsAllowed()
        )
        BottomBarScreenHolder.EditProfile.route -> uiControl.setStatusBarColor(
            Color.Transparent,
            darkIcons = isDarkItemsAllowed()
        )
        BottomBarScreenHolder.Profile.route -> uiControl.setStatusBarColor(
            color = Greenify, darkIcons = isDarkItemsAllowed()
        )
        BottomBarScreenHolder.IdentityFirst.route -> uiControl.setStatusBarColor(
            Color.Transparent,
            darkIcons = isDarkItemsAllowed()
        )
        BottomBarScreenHolder.IdentitySecond.route -> uiControl.setStatusBarColor(
            Color.Transparent,
            darkIcons = isDarkItemsAllowed()
        )
    }
    BottomNavigation(
        elevation = 12.dp,
        backgroundColor = Color.White,
        modifier = Modifier.clip(
            RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
        )
    ) {
        screens.forEach { screen ->
            AddItem(screen = screen, current = current, nav = nav)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreenHolder,
    current: NavDestination?,
    nav: NavHostController
) {
    BottomNavigationItem(selected = current?.hierarchy?.any {
        it.route == screen.route
    } == true, onClick = {
        nav.navigate(screen.route) {
            popUpTo(nav.graph.findStartDestination().id)
            launchSingleTop = true
        }
    },
        label = { Text(text = screen.title) }, icon = {
            Icon(imageVector = screen.icon, contentDescription = "bottom nav icon")
        }, unselectedContentColor = Color.Gray, selectedContentColor = Greenify
    )
}


@Composable
fun HomeScreens(nav: NavHostController) {
    val isdark = isSystemInDarkTheme()
    val colorState = IsDarkOrLight.isDarkOrLight()
    val focusmgr = LocalFocusManager.current
    val isEnabledShimmer by remember {
        mutableStateOf(false)
    }
    val stateoflist = rememberLazyListState()
    val shimmerEffect = listOf(
        Color.LightGray.copy(alpha = 0.6F),
        Color.LightGray.copy(alpha = 0.2F),
        Color.LightGray.copy(alpha = 0.6F)
    )
    val infiniteTransition = rememberInfiniteTransition()
    val animateF = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1400f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearOutSlowInEasing)
        )
    )
    val brush = Brush.linearGradient(
        colors = shimmerEffect,
        start = Offset.Zero,
        end = Offset(x = animateF.value, y = animateF.value)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(if (isdark) Color.Black else backgroundLights)
    ) {
        AnimatedVisibility(
            visible = stateoflist.firstVisibleItemIndex == 0,
            exit = shrinkVertically(), enter = expandVertically()
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
        }
        Column(
            Modifier
                .fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize(), state = stateoflist) {
                item {
                    Spacer(modifier = Modifier.height(37.dp))
                    Image(
                        painter = painterResource(id = R.drawable.mainlogo),
                        modifier = Modifier
                            .width(215.dp)
                            .height(79.dp),
                        contentDescription = "for main menu"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.main_greet),
                        color = Color.White,
                        modifier = Modifier.padding(start = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth(0.9F)
                                .clip(RoundedCornerShape(12.dp)),
                            color = Greenify,
                            elevation = 14.dp
                        ) {
                            CompositionLocalProvider(LocalTextInputService provides null) {
                                TextField(
                                    modifier = Modifier.onFocusChanged {
                                        if (it.hasFocus) {
                                            nav.navigate(BottomBarScreenHolder.SearchMenu.route)
                                        }
                                    },
                                    value = "",
                                    onValueChange = {

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
                                        Text(
                                            text = stringResource(R.string.search_placeholder),
                                            color = Greenify
                                        )
                                    }, keyboardActions = KeyboardActions(onDone = {
                                        focusmgr.clearFocus()
                                    })
                                )
                            }

                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp)
                    ) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 17.sp
                                )
                            ) {
                                append(stringResource(R.string.fr_hot))
                            }
                            withStyle(style = SpanStyle(Color.White, fontSize = 17.sp)) {
                                append(stringResource(R.string.fr_deals))
                            }
                        }, modifier = Modifier.weight(3F))
                        Text(
                            text = stringResource(R.string.see_all),
                            color = Color.White,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .weight(1F)
                                .padding(end = 24.dp)
                                .clickable {

                                }
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(start = 24.dp, end = 12.dp)
                    ) {
                        items(5) {
                            Surface(
                                elevation = 14.dp,
                                shape = RoundedCornerShape(32.dp)
                            ) {
                                RowsOfHotDeals(brush, isEnabledShimmer)
                            }
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp)
                    ) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = colorState,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 17.sp
                                )
                            ) {
                                append(stringResource(R.string.lc_fr))
                            }
                            withStyle(style = SpanStyle(colorState, fontSize = 17.sp)) {
                                append(stringResource(R.string.lc_fr2))
                            }
                        }, modifier = Modifier.weight(3F))
                        Text(
                            text = stringResource(R.string.see_all),
                            color = colorState,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .weight(1F)
                                .padding(end = 24.dp)
                                .clickable {

                                }
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(start = 24.dp, end = 12.dp)
                    ) {
                        items(5) {
                            Surface(
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colors.primary,
                                shape = RoundedCornerShape(12.dp),
                                elevation = 14.dp
                            ) {
                                RowsOfLocationsTop(brush, isEnabledShimmer)
                            }
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, bottom = 22.dp)
                    ) {
                        Text(text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 17.sp)) {
                                append(stringResource(R.string.fr_sg))
                            }
                            withStyle(SpanStyle(fontSize = 17.sp)) {
                                append(stringResource(R.string.fr_bk))
                            }
                        })
                        Text(
                            text = stringResource(R.string.see_all),
                            color = colorState,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .weight(1F)
                                .padding(end = 24.dp)
                                .clickable {

                                }
                        )
                    }
                }
                items(4) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ColumnOfSuggested(
                            brush = Brush.linearGradient(colors = listOf(Color.Green)),
                            isEnabled = false,
                            bikeName = "Xiaomi",
                            "Himo C16",
                            cost = "100.000",
                            rating = "4.5",
                            "10",
                            "Suhat",
                            painterResource(id = R.drawable.imgrecommended)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowsOfHotDeals(brush: Brush, isEnabled: Boolean) {
    Card(
        modifier = Modifier
            .size(202.dp, 231.dp)
            .clickable {}
    ) {
        if (isEnabled) {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush)
            )
        }
    }
}

@Composable
fun RowsOfLocationsTop(brush: Brush, isEnabled: Boolean) {
    Card(modifier = Modifier
        .size(93.dp, 131.dp)
        .clickable { }) {
        if (isEnabled) {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush)
            )
        }
    }
}

@Composable
fun ColumnOfSuggested(
    brush: Brush,
    isEnabled: Boolean,
    bikeName: String,
    fullbikeName: String,
    cost: String,
    rating: String,
    reviewSize: String,
    location: String,
    image: Painter
) {
    val colorstate = IsDarkOrLight.isDarkOrLight()
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(120.dp)
            .clickable { }, elevation = 12.dp
    ) {
        Row(Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .padding(start = 12.dp, top = 12.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(0.4F)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = colorstate
                            )
                        ) {
                            append(bikeName)
                        }
                        withStyle(SpanStyle(fontSize = 12.sp, color = colorstate)) {
                            append(" $fullbikeName")
                        }
                    },
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = colorstate
                        )
                    ) {
                        append("Rp.$cost")
                    }
                    withStyle(SpanStyle(color = Color.Gray, fontSize = 12.sp)) {
                        append(stringResource(R.string.per_days))
                    }
                })
                Spacer(modifier = Modifier.height(8.dp))
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.stars),
                        contentDescription = "stars fav",
                        modifier = Modifier.size(10.dp, 10.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = rating, fontSize = 10.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "$reviewSize reviews", fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(15.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = Greenify.copy(alpha = 0.4F)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = location,
                        color = colorstate,
                        fontSize = 8.sp
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(end = 12.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = "recommend pictures",
                    modifier = Modifier.size(119.dp, 91.dp)
                )
            }
        }
    }
}
