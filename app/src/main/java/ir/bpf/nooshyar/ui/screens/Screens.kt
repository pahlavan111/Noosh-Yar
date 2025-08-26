package ir.bpf.nooshyar.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ir.bpf.nooshyar.R
import ir.bpf.nooshyar.ui.components.MessageItem
import ir.bpf.nooshyar.viewmodels.ChatViewModel


@Composable
fun ChatScreen(viewModel: ChatViewModel) {
    val messages by viewModel.messages.collectAsState()
    val messageInput by viewModel.messageInput

    Column(modifier = Modifier.fillMaxSize()) {
        // Message List
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(top = 32.dp, start = 8.dp, end = 8.dp),
            reverseLayout = false
        ) {
            items(messages) { message ->
                MessageItem(message)
            }
        }

        // Input Field
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = messageInput,
                onValueChange = { viewModel.messageInput.value = it },
                modifier = Modifier.weight(1f),
                label = { Text(stringResource(R.string.enter_your_message)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.sendMessage() }) {
                Text(stringResource(R.string.send))
            }
        }
    }
}