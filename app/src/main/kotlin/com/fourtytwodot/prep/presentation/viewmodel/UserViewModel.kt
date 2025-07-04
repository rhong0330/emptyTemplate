package com.fourtytwodot.prep.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fourtytwodot.prep.data.model.User
import com.fourtytwodot.prep.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users : StateFlow<List<User>> =_users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            getUserUseCase()
                .collect{
                    _users.value = it
                }
        }
    }
}
