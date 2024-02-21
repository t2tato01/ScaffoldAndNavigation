package com.example.scaffoldandnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scaffoldandnavigation.ui.theme.ScaffoldAndNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldAndNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //val navController = rememberNavController()
                    ScaffoldApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title:String, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(title)},
        actions = {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Filled.MoreVert,contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                DropdownMenuItem(text={Text("Info")},onClick = {
                    navController.navigate("info")})
                    //content = {Text("Info") })
                DropdownMenuItem(text = {Text("Settings")},onClick = {
                    navController.navigate("settings")})
                    //content = {Text("Settings")})
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBar(title: String, navController: NavController){
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp()}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    Scaffold (
        topBar = { ScreenTopBar("My App", navController )},
        content = { Text(text = "Content for Home screen")}
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InfoScreen(navController: NavController){
    Scaffold (
        topBar = { ScreenTopBar("info", navController )},
        content = { Text(text = "Content for Info screen")}
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController: NavController){
    Scaffold (
        topBar = { ScreenTopBar("Settings", navController )},
        content = { Text(text = "Content for Setting screen")}
    )
}


@Composable
fun ScaffoldApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
    ){
        composable(route = "Home"){
            MainScreen(navController)
        }
        composable(route = "info"){
            InfoScreen(navController)
        }
        composable(route = "setting") {
            SettingsScreen(navController)
        }
    }
}
/*
@Composable
fun ScaffoldApp(navController: NavController){
    NavHost(
        navController = navController as NavHostController,
        startDestination ="Home"
    ){
        composable(route = "Home"){
            MainScreen(navController)
        }
        composable(route = "Info"){
            InfoScreen(navController)
        }
        composable(route = "Settings"){
            SettingsScreen(navController)
        }
    }
}
*/

// import android.annotation.SuppressLint
// import android.os.Bundle
// import androidx.activity.ComponentActivity
// import androidx.activity.compose.setContent
// import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.material.icons.Icons
// import androidx.compose.material.icons.filled.ArrowBack
// import androidx.compose.material.icons.filled.MoreVert
// import androidx.compose.material3.DropdownMenu
// import androidx.compose.material3.DropdownMenuItem
// import androidx.compose.material3.ExperimentalMaterial3Api
// import androidx.compose.material3.Icon
// import androidx.compose.material3.IconButton
// import androidx.compose.material3.MaterialTheme
// import androidx.compose.material3.Scaffold
// import androidx.compose.material3.Surface
// import androidx.compose.material3.Text
// import androidx.compose.material3.TopAppBar
// import androidx.compose.runtime.Composable
// import androidx.compose.runtime.getValue
// import androidx.compose.runtime.mutableStateOf
// import androidx.compose.runtime.remember
// import androidx.compose.runtime.setValue
// import androidx.compose.ui.Modifier
// import com.example.scaffoldandnavigation.ui.theme.ScaffoldAndNavigationTheme
// import androidx.navigation.NavController
// import androidx.navigation.compose.rememberNavController
// import androidx.navigation.compose.NavHost
// import androidx.navigation.compose.composable
//
//
// class MainActivity : ComponentActivity() {
// override fun onCreate(savedInstanceState: Bundle?) {
// super.onCreate(savedInstanceState)
// setContent {
// ScaffoldAndNavigationTheme {
//
// // A surface container using the 'background' color from the theme
// Surface(
// modifier = Modifier.fillMaxSize(),
// color = MaterialTheme.colorScheme.background
// ) {
// ScaffoldApp()
// }
// }
// }
// }
// }
//
// @OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun MainTopBar(title:String,navController: NavController) {
// var expanded by remember { mutableStateOf(false) =
// TopAppBar(
//
// title = { Text(title)},
// actions = {
// IconButton(
// onClick = {
// expanded =!expanded
// }
// ) {
// Icon(Icons.Filled.MoreVert,contentDescription = null)
// }
// DropdownMenu(
// expanded = expanded,
// onDismissRequest = { expanded =false}) {
// DropdownMenuItem(onClick = {
// navController.navigate("info")},
// text = {Text("Info") })
// DropdownMenuItem(onClick = {
// navController.navigate("settings")},
// text = {Text("Settings")})
// }
// }
// )
// }
//
//
//
// @OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun ScreenTopBar(title: String,navController: NavController){
// TopAppBar(
// title = { Text(title) },
// navigationIcon = {
// IconButton(onClick = { navController.navigateUp()}) {
// Icon(Icons.Filled.ArrowBack, contentDescription = null)
// }
// }
// )
// }
//
// @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
// @Composable
// fun MainScreen(navController: NavController){
// Scaffold (
// topBar = { ScreenTopBar("My App", navController )},
// content = { Text(text = "Content for Home screen")},
// )
// }
//
// @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
// @Composable
// fun InfoScreen(navController: NavController){
// Scaffold (
// topBar = { ScreenTopBar("info", navController )},
// content = { Text(text = "Content for Info screen")},
// )
// }
//
//
// @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
// @Composable
// fun SettingsScreen(navController: NavController){
// Scaffold (
// topBar = { ScreenTopBar("Settings", navController )},
// content = { Text(text = "Content for Setting screen")},
// )
// }
//
// @Composable
// fun ScaffoldApp(navController: NavController){
// val navController = rememberNavController()
// NavHost(
// navController = navController,
// startDestination ="Home"
// ){
// composable(route = "Home"){
// MainScreen(navController)
// }
// composable(route = "Info"){
// InfoScreen(navController)
// }
// composable(route = "Settings"){
// SettingsScreen(navController)
// }
// }
// }}
//
// /