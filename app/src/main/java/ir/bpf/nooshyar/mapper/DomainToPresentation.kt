package ir.bpf.nooshyar.mapper

import ir.bpf.domain.model.Message
import ir.bpf.nooshyar.models.MessageModel

fun Message.toMessageModel(): MessageModel {
    return MessageModel(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp,
    )
}