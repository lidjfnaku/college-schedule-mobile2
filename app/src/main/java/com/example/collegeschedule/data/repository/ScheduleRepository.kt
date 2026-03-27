package com.example.collegeschedule.data.repository

import com.example.collegeschedule.data.api.ScheduleApi
import com.example.collegeschedule.data.dto.ScheduleByDateDto

class ScheduleRepository(private val api: ScheduleApi) {
    suspend fun getSchedule(
        groupName: String,
        start: String,
        end: String
    ): List<ScheduleByDateDto> {
        return api.getSchedule(groupName, start, end)
    }
}