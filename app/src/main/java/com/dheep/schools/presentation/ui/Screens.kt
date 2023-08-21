package com.dheep.schools.presentation.ui

sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    class Detail(name: String): Screens("Detail_screen/${name}")
}