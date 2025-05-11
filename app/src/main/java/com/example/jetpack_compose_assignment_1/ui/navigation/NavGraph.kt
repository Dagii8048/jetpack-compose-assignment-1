package com.example.jetpack_compose_assignment_1.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_assignment_1.ui.components.BackButton
import com.example.jetpack_compose_assignment_1.ui.components.BottomNavigationBar
import com.example.jetpack_compose_assignment_1.ui.screens.AboutScreen
import com.example.jetpack_compose_assignment_1.ui.screens.CompressedCourseScreen
import com.example.jetpack_compose_assignment_1.ui.screens.LaunchScreen
import com.example.jetpack_compose_assignment_1.ui.screens.SpecifiedDepartmentScreen
import com.example.jetpack_compose_assignment_1.ui.screens.SpecifiedYearScreen

object Routes {
    const val LAUNCH = "launch"
    const val DEPARTMENT = "department/{departmentName}"
    const val YEAR = "year/{departmentName}/{year}"
    const val SEMESTER = "semester/{departmentName}/{year}/{semester}"
    const val ABOUT = "about"
}

@Composable
fun ComingSoonScreen(onBack: () -> Unit = {}, onAbout: () -> Unit = {}, onHome: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize()
        .padding(top = 16.dp)) {
        BackButton(onBack = onBack)
        Box(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Coming soon",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF8B5CF6)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
        ) {
            BottomNavigationBar(onHomeClick = onHome, onAboutClick = onAbout)
        }
    }
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Routes.LAUNCH
    ) {
        composable(Routes.LAUNCH) {
            LaunchScreen(
                onDepartmentSelected = { departmentName ->
                    if (departmentName == "Software Engineering") {
                        navController.navigate("department/$departmentName")
                    } else {
                        navController.navigate("department/$departmentName")
                    }
                }
            )
        }
        composable("department/{departmentName}") { backStackEntry ->
            val departmentName = backStackEntry.arguments?.getString("departmentName") ?: ""
            if (departmentName == "Software Engineering") {
                SpecifiedDepartmentScreen(
                    departmentName = departmentName,
                    onYearSelected = { year ->
                        navController.navigate("year/$departmentName/$year")
                    },
                    onBack = { navController.popBackStack() },
                    onAbout = { navController.navigate(Routes.ABOUT) },
                    onHome = {
                        navController.popBackStack(Routes.LAUNCH, inclusive = false)
                    }
                )
            } else {
                ComingSoonScreen(
                    onBack = { navController.popBackStack() },
                    onAbout = { navController.navigate(Routes.ABOUT) },
                    onHome = {
                        navController.popBackStack(Routes.LAUNCH, inclusive = false)
                    }
                )
            }
        }
        composable("year/{departmentName}/{year}") { backStackEntry ->
            val departmentName = backStackEntry.arguments?.getString("departmentName") ?: ""
            val year = backStackEntry.arguments?.getString("year") ?: ""
            if (departmentName == "Software Engineering" && year == "Third Year") {
                SpecifiedYearScreen(
                    departmentName = departmentName,
                    year = year,
                    onSemesterSelected = { semester ->
                        navController.navigate("semester/$departmentName/$year/$semester")
                    },
                    onBack = { navController.popBackStack() },
                    onAbout = { navController.navigate(Routes.ABOUT) },
                    onHome = {
                        navController.popBackStack(Routes.LAUNCH, inclusive = false)
                    }
                )
            } else {
                ComingSoonScreen(
                    onBack = { navController.popBackStack() },
                    onAbout = { navController.navigate(Routes.ABOUT) },
                    onHome = {
                        navController.popBackStack(Routes.LAUNCH, inclusive = false)
                    }
                )
            }
        }
        composable("semester/{departmentName}/{year}/{semester}") { backStackEntry ->
            val departmentName = backStackEntry.arguments?.getString("departmentName") ?: ""
            val year = backStackEntry.arguments?.getString("year") ?: ""
            val semester = backStackEntry.arguments?.getString("semester") ?: ""
            if (departmentName == "Software Engineering" && year == "Third Year" && semester == "1st Semester") {
                CompressedCourseScreen(
                    departmentName = departmentName,
                    year = year,
                    semester = semester,
                    onBack = { navController.popBackStack() },
                    onAbout = { navController.navigate(Routes.ABOUT) },
                    onHome = {
                        navController.popBackStack(Routes.LAUNCH, inclusive = false)
                    }
                )
            } else {
                ComingSoonScreen(
                    onBack = { navController.popBackStack() },
                    onAbout = { navController.navigate(Routes.ABOUT) },
                    onHome = {
                        navController.popBackStack(Routes.LAUNCH, inclusive = false)
                    }
                )
            }
        }
        composable(Routes.ABOUT) {
            AboutScreen(
                onHomeClick = {
                    navController.popBackStack(Routes.LAUNCH, inclusive = false)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
} 