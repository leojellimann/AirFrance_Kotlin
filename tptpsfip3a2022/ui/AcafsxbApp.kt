package com.shindra.aero.tptpsfip3a2022.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.shindra.aero.tptpsfip3a2022.R
import androidx.compose.foundation.Image
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.isUnspecified
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

//Main screen called that stacks all the screen in the app
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcafsxbApp() {
    val navController = rememberNavController()
    Scaffold(
        //Configuration of the TopNavigation
        topBar = {
            TopAppBar(
                title = {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    val currentRoute = currentDestination?.route
                    if (currentRoute == BottomBarScreen.Planes.route){
                        Text(text = stringResource(id = R.string.txt_planes), fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                    }
                    else if (currentRoute == BottomBarScreen.Weather.route){
                        Text(text = stringResource(id = R.string.txt_weather), fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                    }
                    else if (currentRoute == Navigation.Specific.route){
                        if (Navigation.Specific.registration == "F-GMAM"){
                            Text(text = stringResource(id = R.string.txt_GMAM))
                        }
                        else if(Navigation.Specific.registration == "F-GJCO"){
                            Text(text = stringResource(id = R.string.txt_GJCO))
                        }
                        else if(Navigation.Specific.registration == "F-GBQG"){
                            Text(text = stringResource(id = R.string.txt_GBQG))
                        }
                        else if(Navigation.Specific.registration == "F-GBLL"){
                            Text(text = stringResource(id = R.string.txt_GBLL))
                        }
                    }

                },

                navigationIcon = {
                    //Used to know the current screen
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    val currentRoute = currentDestination?.route
                    //Used to check the current screen and to put and arrowback in the top bar in case we navigate in the stack
                    if(currentRoute == Navigation.Specific.route){
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Icon")
                        }
                    }
                },
                backgroundColor = Color(0xFFFFFFFF)
            ) },

        //Configuration of the BottomTabNavigation
        bottomBar = { BottomBar(navController = navController)}
    ) {
        BottomNavGraph(navController = navController)
    }

}

@Composable
fun BottomBar(navController: NavHostController){
    //List of every screens in the bottomnavigation
    val screens = listOf(
        BottomBarScreen.Planes,
        BottomBarScreen.Weather
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Color.White,
    ) {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

//Configuration of the BottomNavigation items
@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    //Both Planes and Weather items of the bottomNavigation
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            if(screen == BottomBarScreen.Planes) {
                Image(painter = painterResource(id = R.drawable.ic_baseline_local_airport_24), contentDescription = "null")
            }
            else if (screen == BottomBarScreen.Weather){
                Image(painter = painterResource(id = R.drawable.ic_baseline_cloud_24), contentDescription = "null")
            }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        selectedContentColor = MaterialTheme.colorScheme.inversePrimary,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
