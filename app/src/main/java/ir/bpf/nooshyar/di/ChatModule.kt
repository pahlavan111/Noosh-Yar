package ir.bpf.mysample.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import ir.bpf.data.repository.ChatRepository
import ir.bpf.domain.repository.IChatRepository
import ir.bpf.domain.usecase.ChatUseCase

@Module
@InstallIn(ViewModelComponent::class)
abstract class ChatBindingModule {
    @Binds
    abstract fun bindMessageRepository(messageRepository: ChatRepository): IChatRepository
}

@Module
@InstallIn(ActivityComponent::class)
class ChatModule {
    @Provides
    fun provideMessageUseCase(messageRepository: ChatRepository) =
        ChatUseCase(messageRepository)
}


