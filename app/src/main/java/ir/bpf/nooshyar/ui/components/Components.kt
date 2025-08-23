package ir.bpf.nooshyar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ir.bpf.nooshyar.models.MessageModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MessageItem(message: MessageModel) {
    val isUserMessage = message.sender == "User"
    val alignment = if (isUserMessage) Alignment.End else Alignment.Start
    val backgroundColor = if (isUserMessage) Color(0xFFDCF8C6) else Color(0xFFF5F5F5)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isUserMessage) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .background(backgroundColor, RoundedCornerShape(12.dp))
                .padding(12.dp)
                .widthIn(max = 250.dp),
            horizontalAlignment = alignment
        ) {
            Text(text = message.content)
            Text(
                text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(message.timestamp)),
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}