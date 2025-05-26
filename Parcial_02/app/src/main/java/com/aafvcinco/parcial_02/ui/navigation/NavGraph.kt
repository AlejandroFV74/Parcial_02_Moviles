package com.aafvcinco.parcial_02.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aafvcinco.parcial_02.model.Product
import com.aafvcinco.parcial_02.ui.screen.DetailedScreen
import com.aafvcinco.parcial_02.ui.screen.ProductScreen
import com.aafvcinco.parcial_02.ui.screen.ShoppingCardScreen
import com.aafvcinco.parcial_02.viewModel.GeneralViewModel


@Composable
fun AppNavGraph(navController: NavHostController){
    val viewModel: GeneralViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController= navController, startDestination = "home") {
        composable("home") {
            ProductScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            "productDetails/{productID}",
            arguments = listOf(navArgument("productID") { type = NavType.IntType })
        ) {
                backStackEntry ->
            val petID = backStackEntry.arguments?.getInt("productID")
            DetailedScreen(navController, petID)
        }
        composable ("shoppingCart") {
            ShoppingCardScreen(viewModel = viewModel, navController = navController)
        }
    }

}