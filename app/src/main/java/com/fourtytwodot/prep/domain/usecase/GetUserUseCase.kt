package com.fourtytwodot.prep.domain.usecase

import com.fourtytwodot.prep.data.model.User
import com.fourtytwodot.prep.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(): Flow<List<User>> = repository.getUsers()
}