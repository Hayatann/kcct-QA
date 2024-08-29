package com.example.chatapplication.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapplication.entity.ChatData
import com.example.chatapplication.entity.sampleChatData
import com.example.chatapplication.ui.theme.ChatApplicationTheme
import java.time.format.DateTimeFormatter

@Composable
fun ChatRow(
    chatData: ChatData = sampleChatData[0],
) {
    Column(
        horizontalAlignment = if(chatData.isOwnMessage) Alignment.End else Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
    ) {
        if(chatData.groupId != 1) {
            Text(
                text = chatData.senderName,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(3.dp, 0.dp)

            )
        }

        if(chatData.isOwnMessage)
        Column(
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    end = 4.dp,
                )
        ){
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .height(45.dp)
                ) {
                    Text(
                        text = chatData.dateTime
                            .format(
                                DateTimeFormatter.ofPattern("hh:mm:ss")
                            ),
                        fontSize = 12.sp,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(5.dp, 0.dp)
                    )
                }
                Text(
                    text = chatData.message,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE3F2FD),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(8.dp)
                )
            }
        } else if (chatData.groupId > 1)
            Column(
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        end = 4.dp,
                    )
            )
        {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = chatData.message,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(8.dp)
                        .widthIn(0.dp, 250.dp)
                )
                Box(
                    modifier = Modifier
                        .height(45.dp)
                ) {
                    Text(
                        text = chatData.dateTime
                            .format(
                                DateTimeFormatter.ofPattern("hh:mm:ss")
                            ),
                        fontSize = 12.sp,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(5.dp, 0.dp)
                        ,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewChatRow() {
    ChatApplicationTheme {
        ChatRow(chatData = ChatData(
            id = 1,
            groupId = 2,
            senderId = 1,
            senderName = "Alice",
            dateTime = sampleChatData[0].dateTime,
            message = "fwajffpawjfjddpwapfpfdwadjwpjfjwpafjp",
            isOwnMessage = false
        )
        )
    }
}
