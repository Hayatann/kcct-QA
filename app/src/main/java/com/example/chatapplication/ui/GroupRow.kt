package com.example.chatapplication.ui

import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapplication.R
import com.example.chatapplication.entity.GroupData
import com.example.chatapplication.entity.groupDataSample
import com.example.chatapplication.ui.theme.ChatApplicationTheme
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun GroupRow(
    groupData: GroupData,
    onClick: () -> Unit = {}
) {
    Surface(
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.AccountCircle,
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
            )
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = groupData.name,
                    fontWeight = FontWeight.Bold
                )
                ShortText(text = groupData.lastMessage)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    text = groupData.lastMessageTime
                        .format(
                            DateTimeFormatter
                                .ofPattern("yyyy/MM/dd (E)")
                        ),
                    color = Color.Gray
                )
                Text(
                    text = groupData.lastMessageTime
                        .format(
                            DateTimeFormatter.ofPattern("hh:mm:ss")
                        ),
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ShortText(
    text: String,
    maxLength: Int = 8,
) {
    val truncatedText = if (text.length > maxLength) {
        text.take(maxLength) + "..."
    } else {
        text
    }

    Text(
        text = truncatedText,
        maxLines = 1
    )
}

@Preview
@Composable
fun PreviewGroupRow() {
    ChatApplicationTheme {
        GroupRow(groupData = groupDataSample[0])
    }
}
