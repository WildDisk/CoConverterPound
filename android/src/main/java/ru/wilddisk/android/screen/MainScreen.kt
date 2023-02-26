package ru.wilddisk.android.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.wilddisk.android.R
import ru.wilddisk.android.theme.CoConverterPoundTheme
import ru.wilddisk.common.model.TablePound
import ru.wilddisk.common.ui.Converter
import ru.wilddisk.common.ui.Table

val screens = listOf(
    Screen.Converter,
    Screen.Table
)

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(elevation = 0.dp, backgroundColor = MaterialTheme.colors.background) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier.padding(8.dp)
                )
                Icon(
                    painterResource(id = R.mipmap.ic_launcher_foreground),
                    contentDescription = stringResource(id = R.string.app_name)
                )
            }
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                screens.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentDestination
                            ?.hierarchy
                            ?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = stringResource(id = screen.resourceId)) },
                        icon = {
                            when(screen.route) {
                                "converter" -> Icon(
                                    painterResource(id = R.drawable.baseline_screen_rotation_alt_24),
                                    contentDescription = stringResource(id = R.string.converter)
                                )
                                "table" -> Icon(
                                    painterResource(id = R.drawable.baseline_table_chart_24),
                                    contentDescription = stringResource(id = R.string.table)
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        
        NavHost(
            navController = navController,
            startDestination = Screen.Converter.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Converter.route) { Converter() }
            composable(Screen.Table.route) { Table(TablePound.table()) }
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun MainScreenPreview() {
    CoConverterPoundTheme {
        Surface(color = MaterialTheme.colors.background) {
            MainScreen()
        }
    }
}