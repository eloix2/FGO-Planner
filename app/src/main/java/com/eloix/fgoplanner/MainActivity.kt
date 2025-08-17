package com.eloix.fgoplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eloix.fgoplanner.repository.BannerRepository
import com.eloix.fgoplanner.ui.screens.BannerDetailScreen
import com.eloix.fgoplanner.ui.screens.BannerListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "bannerList") {
        composable("bannerList") {
            BannerListScreen(onBannerClick = { bannerId ->
                navController.navigate("bannerDetail/$bannerId")
            })
        }
        composable("bannerDetail/{bannerId}") { backStackEntry ->
            val bannerId = backStackEntry.arguments?.getString("bannerId")?.toIntOrNull()
            val banner = BannerRepository.getAllBanners().find { it.id == bannerId }
            banner?.let {
                BannerDetailScreen(it) { navController.popBackStack() }
            }
        }
    }
}
