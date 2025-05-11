package com.example.jetpack_compose_assignment_1.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_assignment_1.ui.components.BackButton
import com.example.jetpack_compose_assignment_1.ui.components.BottomNavigationBar
import com.example.jetpack_compose_assignment_1.ui.components.Title
import com.example.jetpack_compose_assignment_1.ui.components.cards.CourseCardCompressed

@Composable
fun CompressedCourseScreen(
    departmentName: String = "Software Engineering",
    year: String = "Second Year",
    semester: String = "1st Semester",
    onBack: () -> Unit = {},
    onAbout: () -> Unit = {},
    onHome: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp, bottom = 64.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackButton(onBack = onBack)
            Spacer(modifier = Modifier.height(8.dp))
            Title(text = semester)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Number of Courses : 5",
                color = Color(0xFF7C5CFA),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            CourseCardCompressed(
                title = "Web Programming",
                code = "COMP 266",
                creditHour = 5,
                ects = 7.0,
                description = "This course includes the foundations of full-stack website development",
                prerequisites = listOf(
                    "Fundamentals of programming",
                    "Data structures and Algorithms"
                )
            )
            CourseCardCompressed(
                title = "Computer Architecture",
                code = "WBP 277",
                creditHour = 5,
                ects = 7.0,
                description = "This course covers the basics of computer hardware and architecture.",
                prerequisites = listOf(
                    "Digital Logic Design",
                    "Introduction to Computing"
                )
            )
            CourseCardCompressed(
                title = "Networking",
                code = "COMP 277",
                creditHour = 3,
                ects = 5.0,
                description = "This course introduces the fundamentals of computer networking.",
                prerequisites = listOf(
                    "Computer Architecture"
                )
            )
            CourseCardCompressed(
                title = "Database",
                code = "DB 299",
                creditHour = 5,
                ects = 7.0,
                description = "Nothing gets stored without a database. This course introduces real world databases and how to build them.",
                prerequisites = listOf(
                    "Data Structure and Algorithms"
                )
            )
            CourseCardCompressed(
                title = "Programming Basics",
                code = "Prog 101",
                creditHour = 3,
                ects = 5.0,
                description = "This course contains crucial topics to enable the student to write python programs at an intermediate level",
                prerequisites = listOf(
                    "Beginner Friendly",
                    "Basic Maths"
                )
            )
            Spacer(Modifier.height(48.dp))
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
        ) {
            BottomNavigationBar(onAboutClick = onAbout, onHomeClick = onHome)
        }
    }
} 