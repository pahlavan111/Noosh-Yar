package ir.bpf.nooshyar.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.bpf.nooshyar.mapper.toDomain
import ir.bpf.nooshyar.mapper.toMessageModel
import ir.bpf.nooshyar.models.MessageModel
import ir.bpf.domain.usecase.ChatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatUseCase: ChatUseCase
) : ViewModel() {
    private val _messages = MutableStateFlow<List<MessageModel>>(emptyList())
    val messages: StateFlow<List<MessageModel>> = _messages.asStateFlow()

    val messageInput = mutableStateOf("")

    init {
        getMessages()
    }

    fun sendMessage() {
        if (messageInput.value.isNotBlank()) {
            viewModelScope.launch {
                chatUseCase.sendMessage(
                    message = MessageModel(
                        content = messageInput.value,
                        sender = "User"
                    ).toDomain()
                )
                messageInput.value = ""
            }
        }
    }

    private fun getMessages() {
        viewModelScope.launch {
            chatUseCase.getMessages().collect { messageList ->
                _messages.value = messageList.map { it.toMessageModel() }
            }
        }
    }
}
