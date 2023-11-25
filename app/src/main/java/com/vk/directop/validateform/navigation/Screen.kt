package com.vk.directop.validateform.navigation

sealed class Screen(val route: String) {
    object RegistrationScreen : Screen("registration_screen")
    object LazyColumnScreen : Screen("lazy_column_screen")
    object SupportScreen : Screen("support_screen")
    object FibonacciScreen : Screen("fibonacci_screen")
    object ShowImageScreen : Screen("show_image_screen")
    object MainScreen : Screen("main_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
