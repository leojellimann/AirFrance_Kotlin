package com.shindra.aero.tptpsfip3a2022.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Planes.route
    ){
        composable(route = BottomBarScreen.Planes.route){
            ClubPlaneScreen(navController = navController)
        }
        composable(route = Navigation.Specific.route){
            SpecificPlaneScreen()
        }
        composable(route = BottomBarScreen.Weather.route){
            WeatherScreen()
        }
    }
}