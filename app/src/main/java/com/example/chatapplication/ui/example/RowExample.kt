package com.example.chatapplication.ui.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatapplication.R
import com.example.chatapplication.ui.theme.ChatApplicationTheme
@Composable
fun RowExample() {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Image(painter = painterResource(id = R.drawable.ic_group), contentDescription = "")
        Text(text = "行だよ")
        Text(text = "行だよ")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRowExample() {
    ChatApplicationTheme {
        RowExample()
    }
}