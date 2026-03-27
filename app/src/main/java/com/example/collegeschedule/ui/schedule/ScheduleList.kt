package com.example.collegeschedule.ui.schedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.collegeschedule.data.dto.ScheduleByDateDto

@Composable
fun ScheduleList(schedule: List<ScheduleByDateDto>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(schedule) { day ->
            DayCard(day)
        }
    }
}

@Composable
fun DayCard(day: ScheduleByDateDto) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${day.lessonDate} • ${day.weekday}",
                style = MaterialTheme.typography.titleMedium
            )
            day.lessons.forEach { lesson ->
                LessonItem(lesson)
            }
        }
    }
}

@Composable
fun LessonItem(lesson: com.example.collegeschedule.data.dto.LessonDto) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        Text(
            text = "${lesson.lessonNumber}. ${lesson.time}",
            style = MaterialTheme.typography.bodyLarge
        )
        // Проходим по подгруппам
        for ((groupPart, details) in lesson.groupParts) {
            if (details != null) {
                Text(
                    text = "   ${groupPart.name}: ${details.subject} - ${details.teacher}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}