package com.prep.fourtytwodot.prep.domain.usercase

import com.prep.fourtytwodot.prep.data.model.User
import com.prep.fourtytwodot.prep.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository){
    operator fun invoke(): Flow<List<User>> = repository.getUsers()
}