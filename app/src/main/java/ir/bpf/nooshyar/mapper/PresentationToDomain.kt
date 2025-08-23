package ir.bpf.nooshyar.mapper

import ir.bpf.domain.model.Message
import ir.bpf.nooshyar.models.MessageModel

fun MessageModel.toDomain(): Message {
    return Message(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp,
    )
}