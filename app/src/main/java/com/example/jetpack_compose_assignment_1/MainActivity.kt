package com.example.jetpack_compose_assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpack_compose_assignment_1.ui.navigation.AppNavGraph
import com.example.jetpack_compose_assignment_1.ui.theme.Mobile_Individual_AssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobile_Individual_AssignmentTheme {
                AppNavGraph()
            }
        }
    }
}

