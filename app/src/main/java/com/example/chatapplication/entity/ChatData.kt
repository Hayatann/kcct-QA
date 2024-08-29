package com.example.chatapplication.entity

import java.time.LocalDateTime

data class ChatData(
    val id: Int,
    val groupId: Int,
    val senderId: Int,
    val senderName: String,
    val dateTime: LocalDateTime,
    var message: String,
    var isOwnMessage: Boolean = false,
)


val sampleChatData = listOf(
    ChatData(1, 1, 1, "Alice",  LocalDateTime.now().minusHours(1), "Hello", true),
    ChatData(2, 1, 2, "Bob",  LocalDateTime.now().minusHours(2), "Hi"),
    ChatData(3, 1, 1, "Alice", LocalDateTime.now().minusHours(3), "How are you?", true),
    ChatData(4, 1, 2, "Bob", LocalDateTime.now().minusHours(4), "I'm fine, thank you."),
    ChatData(5, 1, 1, "Alice", LocalDateTime.now().minusHours(5), "Good to hear that.", true),
    ChatData(6, 1, 2, "Bob", LocalDateTime.now().minusHours(6), "How about you?"),
    ChatData(7, 1, 1, "Alice", LocalDateTime.now().minusHours(7), "I'm good too.", true),
    ChatData(8, 1, 2, "Bob", LocalDateTime.now().minusHours(8), "That's great!"),
    ChatData(9, 1, 1, "Alice", LocalDateTime.now().minusHours(9), "Bye", true),
    ChatData(10, 1, 2, "Bob", LocalDateTime.now().minusHours(10), "See you later"),
    ChatData(11, 1, 3, "Charlie", LocalDateTime.now().minusHours(11), "Hey"),
    ChatData(12, 1, 4, "David", LocalDateTime.now().minusHours(12), "Hi"),
    ChatData(13, 1, 3, "Charlie", LocalDateTime.now().minusHours(13), "How's it going?"),
    ChatData(14, 1, 4, "David", LocalDateTime.now().minusHours(14), "Not bad."),
    ChatData(15, 1, 3, "Charlie", LocalDateTime.now().minusHours(15), "That's good to hear."),
    ChatData(16, 1, 4, "David", LocalDateTime.now().minusHours(16), "How about you?"),
    ChatData(17, 1, 3, "Charlie", LocalDateTime.now().minusHours(17), "I'm doing well."),
    ChatData(18, 1, 4, "David", LocalDateTime.now().minusHours(18), "That's nice."),
    ChatData(19, 1, 3, "Charlie", LocalDateTime.now().minusHours(19), "Gotta go."),
    ChatData(20, 1, 4, "David", LocalDateTime.now().minusHours(20), "Take care."),
    ChatData(21, 1, 5, "Eve", LocalDateTime.now().minusHours(21), "Hello"),
    ChatData(22, 1, 6, "Frank", LocalDateTime.now().minusHours(22), "Hi"),
)