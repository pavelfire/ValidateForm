package com.vk.directop.validateform.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vk.directop.validateform.data.Category
import com.vk.directop.validateform.data.names

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.RegistrationScreen.route
    ) {
        composable(route = Screen.RegistrationScreen.route) {
            Registration(navController = navController)
        }
        composable(route = Screen.LazyColumnScreen.route) {
            val namesList = names.map {
                Category(
                    name = it.key.toString(),
                    items = it.value
                )
            }
            CategorizedLazyColumn(namesList)
        }
        composable(route = Screen.SupportScreen.route) {
            val namesList = names.map {
                Category(
                    name = it.key.toString(),
                    items = it.value
                )
            }
            SupportScreen(namesList)
        }
    }
}