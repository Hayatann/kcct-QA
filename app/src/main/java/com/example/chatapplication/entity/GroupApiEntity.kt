package com.example.chatapplication.entity

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class GroupApiEntity(
    val id: Int,
    val name: String,
    val lastMessage: String,
    val lastMessageAt: String,
    val createdAt: String
)

fun List<GroupApiEntity>.convertUIData(): ArrayList<GroupData> {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val groupList = arrayListOf<GroupData>()
    this.forEach {
        groupList.add(
            GroupData(
                id = it.id,
                name = it.name,
                lastMessage = it.lastMessage,
                lastMessageTime = LocalDateTime.parse(it.lastMessageAt, formatter)
            )
        )
    }
    return groupList
}
