package com.example.jetpack_compose_assignment_1.ui.components.cards

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CourseCardCompressed(
    title: String,
    code: String,
    creditHour: Int,
    ects: Double,
    description: String,
    prerequisites: List<String>,
) {
    var expanded by remember { mutableStateOf(false) }
    val valueColor = Color(0xFF8A8D91)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E2E5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize(),
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4287f5),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "Course code : ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = code,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = valueColor
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            if (!expanded) {
                Column {
                    Row {
                        Text(
                            text = "Credit hour : ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "$creditHour",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = valueColor
                        )
                    }
                    Row {
                        Text(
                            text = "Total ECTS : ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "%.2f".format(ects),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = valueColor
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Text(
                            text = "Credit hour : ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "$creditHour",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = valueColor
                        )
                    }
                    Row {
                        Text(
                            text = "Total ECTS : ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "%.2f".format(ects),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = valueColor
                        )
                    }
                }
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Course Description:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = description,
                    fontSize = 15.sp,
                    color = valueColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Prerequisite",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Column {
                    prerequisites.forEach {
                        Text(
                            text = "• $it",
                            fontSize = 15.sp,
                            color = valueColor
                        )
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = if (expanded) "Hide Details" else "View Details",
                    color = Color(0xFF1976D2),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    tint = valueColor
                )
            }
        }
    }
}
