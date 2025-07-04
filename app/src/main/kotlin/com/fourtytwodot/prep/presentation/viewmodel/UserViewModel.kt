package com.fourtytwodot.prep.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.fourtytwodot.prep.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {


}