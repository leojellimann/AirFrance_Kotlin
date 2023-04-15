package com.shindra.aero.tptpsfip3a2022

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shindra.aero.tptpsfip3a2022.ui.AcafsxbApp
import com.shindra.aero.tptpsfip3a2022.ui.BottomNavGraph
import com.shindra.aero.tptpsfip3a2022.ui.ClubPlaneScreen
import com.shindra.aero.tptpsfip3a2022.ui.components.SpecPlaneCard
import com.shindra.aero.tptpsfip3a2022.ui.theme.TpTpsFip3A2022Theme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TpTpsFip3A2022Theme {
                navController = rememberNavController()
                BottomNavGraph(navController = navController)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Main screen launched in the app
                    AcafsxbApp()
                }
            }
        }
    }
}
