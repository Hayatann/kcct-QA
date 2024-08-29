package com.example.chatapplication.entity

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ChatApiEntity(
    val id: Int,
    val groupId: Int,
    val senderId: Int,
    val senderName: String,
    val dateTime: String,
    var message: String,
)

fun List<ChatApiEntity>.convertUIData(): ArrayList<ChatData> {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val chatList = arrayListOf<ChatData>()
    this.forEach {
        chatList.add(
            ChatData(
                id = it.id,
                groupId = it.groupId,
                senderId = it.senderId,
                senderName = it.senderName,
                dateTime = LocalDateTime.parse(it.dateTime, formatter),
                message = it.message,
                isOwnMessage = it.senderId == 1 || it.groupId == 1
            )
        )
    }
    return chatList
}
