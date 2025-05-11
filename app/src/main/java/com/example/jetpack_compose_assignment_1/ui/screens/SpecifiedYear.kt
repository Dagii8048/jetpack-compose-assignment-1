package com.example.jetpack_compose_assignment_1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_assignment_1.ui.components.BackButton
import com.example.jetpack_compose_assignment_1.ui.components.Title
import com.example.jetpack_compose_assignment_1.ui.components.BottomNavigationBar

@Composable
fun SpecifiedYearScreen(
    departmentName: String = "Software Engineering",
    year: String = "Second Year",
    onSemesterSelected: (String) -> Unit = {},
    onBack: () -> Unit = {},
    onAbout: () -> Unit = {},
    onHome: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 64.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackButton(onBack = onBack)
            Spacer(modifier = Modifier.height(16.dp))
            Title(text = "$departmentName")
            Spacer(modifier = Modifier.height(16.dp))
            SemesterButton("1st Semester") { onSemesterSelected("1st Semester") }
            Spacer(modifier = Modifier.height(12.dp))
            SemesterButton("2nd Semester") { onSemesterSelected("2nd Semester") }
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

@Composable
fun SemesterButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE0E2E5),
            disabledContainerColor = Color(0xFFE0E2E5),
            disabledContentColor = Color(0xFF8A8D91)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

