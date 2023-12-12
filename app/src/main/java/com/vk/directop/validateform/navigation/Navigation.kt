package com.vk.directop.validateform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vk.directop.validateform.data.Category
import com.vk.directop.validateform.data.names
import com.vk.directop.validateform.presentation.SupportScreen
import com.vk.directop.validateform.presentation.books.BooksApp
import com.vk.directop.validateform.presentation.categorized_lazy.CategorizedLazyColumn
import com.vk.directop.validateform.presentation.fibonacci.FibonacciScreen
import com.vk.directop.validateform.presentation.image_coil.ShowImage
import com.vk.directop.validateform.presentation.main_screen.MainScreen
import com.vk.directop.validateform.presentation.registration.Registration

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
        composable(route = Screen.FibonacciScreen.route){
            FibonacciScreen()
        }
        composable(route = Screen.ShowImageScreen.route){
            ShowImage()
        }
        composable(route = Screen.MainScreen.route){
            MainScreen()
        }
        composable(route = Screen.BooksScreen.route){
            BooksApp()
        }
    }
}