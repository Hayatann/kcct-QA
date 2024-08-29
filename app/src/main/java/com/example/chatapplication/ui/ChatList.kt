package com.example.chatapplication.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.chatapplication.entity.ChatData

@Composable
fun ChatList(
    chatDataList: List<ChatData>,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    LazyColumn(
        modifier = modifier
            .clickableNoRipple {
                focusManager.clearFocus()
            }
    ) {
        items(chatDataList) { chatData ->
            ChatRow(chatData = chatData)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

fun Modifier.clickableNoRipple(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier = composed {
    this.clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = onClick
    )
}