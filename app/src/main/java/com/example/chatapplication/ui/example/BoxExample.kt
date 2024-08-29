package com.example.chatapplication.ui.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapplication.R
import com.example.chatapplication.ui.theme.ChatApplicationTheme

@Composable
fun BoxExample() {
    Box(modifier = Modifier.size(300.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_group),
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "左上だよ",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            text = "上だよ",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Text(
            text = "右上だよ",
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Text(
            text = "左だよ",
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Text(
            text = "右だよ",
            modifier = Modifier.align(Alignment.CenterEnd)
        )
        Text(
            text = "下だよ",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        Text(
            text = "左下だよ",
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            text = "右下だよ",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBoxExample() {
    ChatApplicationTheme {
        BoxExample()
    }
}